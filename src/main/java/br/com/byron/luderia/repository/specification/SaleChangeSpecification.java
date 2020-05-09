package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.SaleChangeFilter;
import br.com.byron.luderia.domain.model.SaleChange;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class SaleChangeSpecification extends GenericSpecification<SaleChange, SaleChangeFilter> {

	private static final long serialVersionUID = -5790656276003453737L;

	@Override
	public Predicate toPredicate(Root<SaleChange> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new SaleChange());

		return predicate;

	}

}
