package br.com.byron.luderia.strategy.strategies;

import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.domain.model.Coupon;
import br.com.byron.luderia.domain.model.Product;
import br.com.byron.luderia.domain.model.Sale;
import br.com.byron.luderia.domain.model.SaleItem;
import br.com.byron.luderia.repository.ICouponRepository;
import br.com.byron.luderia.repository.IProductRepository;
import br.com.byron.luderia.strategy.IStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaleQuantityStrategy implements IStrategy<Sale> {

    private final ICouponRepository couponRepository;

    private final IProductRepository productRepository;

    @Override
    public void execute(Sale sale) throws NotFoundEntityException {
        if (sale.getCoupon() != null && sale.getCoupon().getId() != null) {
            Coupon coupon = couponRepository.findById(sale.getCoupon().getId()).orElseThrow(() -> new NotFoundEntityException("Coupon not found"));
            if (coupon.getUsedQuatity() == coupon.getQuantity()) {
                //TODO THROW ERROR
            }
        }

        for (SaleItem item : sale.getItems()) {
            Product product = productRepository.findById(item.getProduct().getId()).orElseThrow(() -> new NotFoundEntityException("Product not found"));
            if (product.getQuantityStock() < item.getQuantity()) {
                //TODO THROW ERROR
            }
        }
    }

}
