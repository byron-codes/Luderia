package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.GameSystemFilter;
import br.com.byron.luderia.model.GameSystem;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class GameSystemSpecification extends GenericSpecification<GameSystem, GameSystemFilter> {

	private static final long serialVersionUID = 7369460730902537374L;

	@Override
	public Predicate toPredicate(Root<GameSystem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new GameSystem());

		return predicate;

	}

}
