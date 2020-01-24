package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Coupon;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.model.SaleAd;
import br.com.byron.luderia.model.SaleItem;
import br.com.byron.luderia.model.SaleStatus;
import br.com.byron.luderia.repository.ISaleRepository;
import br.com.byron.luderia.repository.specification.SaleSpecification;

@Service
public class SaleService extends GenericService<Sale, SaleFilter> {

	private ISaleRepository repository;

	private SaleAdService adService;

	private CouponService couponService;

	SaleService(ISaleRepository repository, SaleAdService adService, CouponService couponService) {
		super(repository);
		this.repository = repository;
		this.adService = adService;
		this.couponService = couponService;
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
		
		Double total = 0.0;
		Double couponTotal = 0.0;

		for (Coupon coupon : sale.getCoupons()) {

			coupon = couponService.find(coupon);

			// TODO Mudar pra strategy
			if (coupon.getUsedQuatity() < coupon.getQuatity()) {

				couponTotal += coupon.getValue();
				coupon.setUsedQuatity(coupon.getUsedQuatity() + 1);
				couponService.update(coupon);

			} else {
				// TODO Throw error
			}

		}

		for (SaleItem item : sale.getItems()) {

			SaleAd ad = adService.find(item.getAd());

			// TODO Mudar pra strategy
			if (ad.getQuantity() >= item.getQuantity()) {

				ad.setQuantity(ad.getQuantity() - item.getQuantity());
				total += ad.getValue() * item.getQuantity();
				adService.update(ad);

				sale.setSaleStatus(SaleStatus.PROCESSING);

				if (couponTotal > total) {
					total = 0.0;
				} else {
					total -= couponTotal;
				}

				sale.setTotal(total);

			} else {
				// TODO Throw error
			}

		}

		// TODO processar frete
		// TODO Processar pagamento
		
		return super.add(sale);

	}

}
