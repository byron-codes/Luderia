package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.SleeveModelFilter;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.model.SleeveModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SleeveModelSpecification extends GenericSpecification<SleeveModel, SleeveModelFilter> {

	private static final long serialVersionUID = -7422531443831981920L;
	
	private final SleeveModelFilter filter;

	@Override
	public Predicate toPredicate(Root<SleeveModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new SleeveModel());

		return predicate;

	}

}
