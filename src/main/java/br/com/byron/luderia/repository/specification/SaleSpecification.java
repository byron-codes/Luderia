package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.model.Sale;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class SaleSpecification extends GenericSpecification<Sale, SaleFilter> {

	private static final long serialVersionUID = -5790656276003453737L;

	@Override
	public Predicate toPredicate(Root<Sale> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Sale());

		return predicate;

	}

}
