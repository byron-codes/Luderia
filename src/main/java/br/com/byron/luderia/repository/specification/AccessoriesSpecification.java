package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.AccessoriesFilter;
import br.com.byron.luderia.model.Accessories;
import br.com.byron.luderia.model.GameCategory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccessoriesSpecification extends GenericSpecification<Accessories, AccessoriesFilter> {

	private static final long serialVersionUID = 501841039592618160L;
	
	private final AccessoriesFilter filter;

	@Override
	public Predicate toPredicate(Root<Accessories> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new Accessories());

		return predicate;

	}
	
}
