package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.ExpansionFilter;
import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.model.Expansion;
import br.com.byron.luderia.model.Game;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class ExpansionSpecification extends GenericSpecification<Expansion, ExpansionFilter> {
	
	private final ExpansionFilter filter;

	@Override
	public Predicate toPredicate(Root<Expansion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new Expansion());

		return predicate;

	}

}
