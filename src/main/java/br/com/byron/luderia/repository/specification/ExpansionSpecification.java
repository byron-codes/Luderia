package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.ExpansionFilter;
import br.com.byron.luderia.domain.model.Expansion;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class ExpansionSpecification extends GenericSpecification<Expansion, ExpansionFilter> {

	@Override
	public Predicate toPredicate(Root<Expansion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Expansion());

		return predicate;

	}

}
