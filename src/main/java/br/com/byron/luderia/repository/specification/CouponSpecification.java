package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.CouponFilter;
import br.com.byron.luderia.domain.model.Coupon;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class CouponSpecification extends GenericSpecification<Coupon, CouponFilter> {

	private static final long serialVersionUID = 7363028962867414942L;

	@Override
	public Predicate toPredicate(Root<Coupon> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Coupon());

		return predicate;

	}

}
