package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.AwardFilter;
import br.com.byron.luderia.model.Award;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class AwardSpecification extends GenericSpecification<Award, AwardFilter> {

	private static final long serialVersionUID = -5514872636727614988L;

	@Override
	public Predicate toPredicate(Root<Award> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Award());

		return predicate;

	}

}
