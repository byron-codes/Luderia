package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.AccessoriesFilter;
import br.com.byron.luderia.domain.model.Accessories;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class AccessoriesSpecification extends GenericSpecification<Accessories, AccessoriesFilter> {

	private static final long serialVersionUID = 501841039592618160L;

	@Override
	public Predicate toPredicate(Root<Accessories> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Accessories());

		return predicate;

	}
	
}
