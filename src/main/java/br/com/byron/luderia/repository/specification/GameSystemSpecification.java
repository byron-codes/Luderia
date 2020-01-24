package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.GameSystemFilter;
import br.com.byron.luderia.model.GameSystem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameSystemSpecification extends GenericSpecification<GameSystem, GameSystemFilter> {

	private static final long serialVersionUID = 7369460730902537374L;
	
	private final GameSystemFilter filter;

	@Override
	public Predicate toPredicate(Root<GameSystem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
