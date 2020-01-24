package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.CouponFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Coupon;
import br.com.byron.luderia.repository.ICouponRepository;
import br.com.byron.luderia.repository.specification.CouponSpecification;

@Service
public class CouponService extends GenericService<Coupon, CouponFilter> {

	private ICouponRepository repository;
	
	CouponService(ICouponRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Coupon> find(CouponFilter filter) {
		List<Coupon> entities = repository.findAll(new CouponSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

	@Override
	public Coupon add(Coupon entity) {
		entity.setUsedQuatity(0);
		return super.add(entity);
	}
	
}
