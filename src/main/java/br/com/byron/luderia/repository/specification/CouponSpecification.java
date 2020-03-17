package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.CouponFilter;
import br.com.byron.luderia.model.Author;
import br.com.byron.luderia.model.Coupon;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CouponSpecification extends GenericSpecification<Coupon, CouponFilter> {

	private static final long serialVersionUID = 7363028962867414942L;
	
	private final CouponFilter filter;

	@Override
	public Predicate toPredicate(Root<Coupon> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new Coupon());

		return predicate;

	}

}
