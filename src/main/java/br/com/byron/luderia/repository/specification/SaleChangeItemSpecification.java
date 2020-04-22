package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.SaleChangeItemFilter;
import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.model.SaleChangeItem;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class SaleChangeItemSpecification extends GenericSpecification<SaleChangeItem, SaleChangeItemFilter> {

	private static final long serialVersionUID = -5790656276003453737L;
	
	private final SaleChangeItemFilter filter;

	@Override
	public Predicate toPredicate(Root<SaleChangeItem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new SaleChangeItem());

		return predicate;

	}

}
