package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.StateFilter;
import br.com.byron.luderia.domain.model.State;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class StateSpecification extends GenericSpecification<State, StateFilter> {

	private static final long serialVersionUID = -3798921289834329268L;

	@Override
	public Predicate toPredicate(Root<State> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new State());

		return predicate;

	}

}
