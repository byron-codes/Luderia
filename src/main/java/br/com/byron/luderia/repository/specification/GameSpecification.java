package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.GameFilter;
import br.com.byron.luderia.domain.model.Game;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class GameSpecification extends GenericSpecification<Game, GameFilter> {

	private static final long serialVersionUID = 3671519219523852170L;

	@Override
	public Predicate toPredicate(Root<Game> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Game());

		return predicate;

	}

}
