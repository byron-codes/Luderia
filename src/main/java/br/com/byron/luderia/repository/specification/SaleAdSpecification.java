package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.SaleAdFilter;
import br.com.byron.luderia.model.SaleAd;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class SaleAdSpecification extends GenericSpecification<SaleAd, SaleAdFilter> {

	private static final long serialVersionUID = 8217452861791575659L;

	@Override
	public Predicate toPredicate(Root<SaleAd> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new SaleAd());

		return predicate;

	}

}
