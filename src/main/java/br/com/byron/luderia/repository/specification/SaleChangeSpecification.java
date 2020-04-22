package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.SaleChangeFilter;
import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.model.SaleChange;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class SaleChangeSpecification extends GenericSpecification<SaleChange, SaleChangeFilter> {

	private static final long serialVersionUID = -5790656276003453737L;
	
	private final SaleChangeFilter filter;

	@Override
	public Predicate toPredicate(Root<SaleChange> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new SaleChange());

		return predicate;

	}

}
