package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.CityFilter;
import br.com.byron.luderia.dto.filter.StateFilter;
import br.com.byron.luderia.model.City;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.model.State;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class StateSpecification extends GenericSpecification<State, StateFilter> {

	private static final long serialVersionUID = -3798921289834329268L;
	
	private final StateFilter filter;

	@Override
	public Predicate toPredicate(Root<State> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new State());

		return predicate;

	}

}
