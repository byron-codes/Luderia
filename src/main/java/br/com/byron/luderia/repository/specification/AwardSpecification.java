package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.AwardFilter;
import br.com.byron.luderia.model.Award;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AwardSpecification extends GenericSpecification<Award, AwardFilter> {

	private static final long serialVersionUID = -5514872636727614988L;
	
	private final AwardFilter filter;

	@Override
	public Predicate toPredicate(Root<Award> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
