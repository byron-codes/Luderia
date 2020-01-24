package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.SaleAdFilter;
import br.com.byron.luderia.model.SaleAd;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaleAdSpecification extends GenericSpecification<SaleAd, SaleAdFilter> {

	private static final long serialVersionUID = 8217452861791575659L;
	
	private final SaleAdFilter filter;

	@Override
	public Predicate toPredicate(Root<SaleAd> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
