package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.model.Game;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameSpecification extends GenericSpecification<Game, GameFilter> {

	private static final long serialVersionUID = 3671519219523852170L;
	
	private final GameFilter filter;

	@Override
	public Predicate toPredicate(Root<Game> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
