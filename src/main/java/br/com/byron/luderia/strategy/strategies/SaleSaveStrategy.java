package br.com.byron.luderia.strategy.strategies;

import br.com.byron.luderia.domain.enumerable.SaleStatus;
import br.com.byron.luderia.domain.model.*;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.repository.*;
import br.com.byron.luderia.service.FreightService;
import br.com.byron.luderia.strategy.IStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SaleSaveStrategy implements IStrategy<Sale> {

    private final IAddressRepository addressRepository;

    private final FreightService freightService;

    private final IUserRepository userRepository;

    private final ICouponRepository couponRepository;

    private final IProductRepository productRepository;

    private final ISaleItemRepository saleItemRepository;

    @Override
    public void execute(Sale sale) throws NotFoundEntityException {
        sale.setAddress(addressRepository.findById(sale.getAddress().getId()).orElseThrow(() -> new RuntimeException()));
        sale.setFreight(freightService.calculate(sale.getAddress().getCep()).getFreight());
        sale.setBuyer(userRepository.findById(sale.getBuyer().getId()).orElseThrow(() -> new RuntimeException()));

        Double total = 0.0;
        Double couponTotal = 0.0;

        if (sale.getCoupon() != null && sale.getCoupon().getId() != null) {
            Coupon coupon = couponRepository.findById(sale.getCoupon().getId()).orElseThrow(() -> new NotFoundEntityException("Coupon not found"));
            couponTotal += coupon.getValue();
            coupon.setUsedQuatity(coupon.getUsedQuatity() + 1);
            couponRepository.save(coupon);
        } else {
            sale.setCoupon(null);
        }


        for (SaleItem item : sale.getItems()) {

            Product product = productRepository.findById(item.getProduct().getId()).orElseThrow(() -> new NotFoundEntityException("Product not found"));

            product.setQuantityStock(product.getQuantityStock() - item.getQuantity());
            total += product.getValue() * item.getQuantity();
            productRepository.save(product);

        }

        sale.setSaleStatus(SaleStatus.PROCESSING);

        if (couponTotal > total) {
            total = 0.0;
        } else {
            total -= couponTotal;
        }

        if (sale.getBuyer().getBalance() >= total) {
            sale.getBuyer().setBalance(sale.getBuyer().getBalance() - total);
            total = 0.0;
        } else {
            sale.getBuyer().setBalance(0.0);
            total -= sale.getBuyer().getBalance();
        }

        total += sale.getFreight();

        sale.setTotal(total);

        sale.getBuyer().setSalesValue(sale.getBuyer().getSalesValue() + total);
        userRepository.save(sale.getBuyer());


        List<SaleItem> saleItems = new ArrayList<>();
        for (SaleItem saleItem : sale.getItems()) {
            saleItems.add(saleItemRepository.save(saleItem));
        }
        sale.setItems(saleItems);
    }

}
