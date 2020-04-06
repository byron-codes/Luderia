package br.com.byron.luderia.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.byron.luderia.model.*;
import br.com.byron.luderia.repository.IAddressRepository;
import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.repository.ISaleRepository;
import br.com.byron.luderia.repository.specification.SaleSpecification;

@Service
public class SaleService extends GenericService<Sale, SaleFilter> {

    private ISaleRepository repository;

    private ProductService productService;

    private CouponService couponService;

    private SaleItemService saleItemService;

    private FreightService freightService;

    private IAddressRepository addressRepository;

    SaleService(ISaleRepository repository, ProductService productService, CouponService couponService, SaleItemService saleItemService, FreightService freightService, IAddressRepository addressRepository) {
        super(repository);
        this.repository = repository;
        this.productService = productService;
        this.couponService = couponService;
        this.saleItemService = saleItemService;
        this.freightService = freightService;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Sale> find(SaleFilter filter) {
        List<Sale> entities = repository.findAll(new SaleSpecification(filter));
        if (entities.isEmpty()) {
            throw new NotFoundEntityException("Entity not found");
        }
        return entities;
    }

    @Override
    public Sale add(Sale sale) {

        sale.setAddress(addressRepository.findById(sale.getAddress().getId()).orElseThrow(() -> new RuntimeException()));
        sale.setFreight(freightService.calculate(sale.getAddress().getCep()).getFreight());

        Double total = 0.0;
        Double couponTotal = 0.0;


        if (sale.getCoupon() != null && sale.getCoupon().getId() != null) {
            Coupon coupon = couponService.find(sale.getCoupon());
            // TODO Mudar pra strategy
            if (coupon.getUsedQuatity() < coupon.getQuantity()) {

                couponTotal += coupon.getValue();
                coupon.setUsedQuatity(coupon.getUsedQuatity() + 1);
                couponService.update(coupon);

            } else {
                // TODO Throw error
            }
        } else {
            sale.setCoupon(null);
        }


        for (SaleItem item : sale.getItems()) {

            Product product = productService.find(item.getProduct());

            // TODO Mudar pra strategy
            if (product.getQuantityStock() >= item.getQuantity()) {

                product.setQuantityStock(product.getQuantityStock() - item.getQuantity());
                total += product.getValue() * item.getQuantity();
                productService.update(product);

                sale.setSaleStatus(SaleStatus.PROCESSING);

                if (couponTotal > total) {
                    total = 0.0;
                } else {
                    total -= couponTotal;
                }

                total += sale.getFreight();

                sale.setTotal(total);

            } else {
                // TODO Throw error
            }

        }

        sale.setDate(LocalDateTime.now());

        List<SaleItem> saleItems = new ArrayList<>();
        for (SaleItem saleItem : sale.getItems()) {
            saleItems.add(saleItemService.add(saleItem));
        }
        sale.setItems(saleItems);

        // TODO Processar pagamento

        return super.add(sale);

    }

}
