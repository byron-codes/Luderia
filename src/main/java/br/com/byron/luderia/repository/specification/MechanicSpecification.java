package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.MechanicFilter;
import br.com.byron.luderia.model.Mechanic;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class MechanicSpecification extends GenericSpecification<Mechanic, MechanicFilter> {

	private static final long serialVersionUID = 7934490432834229640L;

	@Override
	public Predicate toPredicate(Root<Mechanic> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Mechanic());

		return predicate;

	}

}
