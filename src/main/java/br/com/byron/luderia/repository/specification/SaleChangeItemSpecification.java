package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.SaleChangeItemFilter;
import br.com.byron.luderia.domain.model.SaleChangeItem;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class SaleChangeItemSpecification extends GenericSpecification<SaleChangeItem, SaleChangeItemFilter> {

	private static final long serialVersionUID = -5790656276003453737L;

	@Override
	public Predicate toPredicate(Root<SaleChangeItem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new SaleChangeItem());

		return predicate;

	}

}
