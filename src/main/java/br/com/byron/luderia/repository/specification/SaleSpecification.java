package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.model.Sale;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaleSpecification extends GenericSpecification<Sale, SaleFilter> {

	private static final long serialVersionUID = -5790656276003453737L;
	
	private final SaleFilter filter;

	@Override
	public Predicate toPredicate(Root<Sale> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new Sale());

		return predicate;

	}

}
