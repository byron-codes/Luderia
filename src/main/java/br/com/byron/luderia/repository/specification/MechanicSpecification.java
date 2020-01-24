package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.MechanicFilter;
import br.com.byron.luderia.model.Mechanic;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MechanicSpecification extends GenericSpecification<Mechanic, MechanicFilter> {

	private static final long serialVersionUID = 7934490432834229640L;
	
	private final MechanicFilter filter;

	@Override
	public Predicate toPredicate(Root<Mechanic> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
