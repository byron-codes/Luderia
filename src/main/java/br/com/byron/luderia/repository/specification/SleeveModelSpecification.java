package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.SleeveModelFilter;
import br.com.byron.luderia.domain.model.SleeveModel;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class SleeveModelSpecification extends GenericSpecification<SleeveModel, SleeveModelFilter> {

	private static final long serialVersionUID = -7422531443831981920L;

	@Override
	public Predicate toPredicate(Root<SleeveModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new SleeveModel());

		return predicate;

	}

}
