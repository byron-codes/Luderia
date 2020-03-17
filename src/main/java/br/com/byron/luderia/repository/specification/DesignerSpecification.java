package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.DesignerFilter;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.model.Designer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DesignerSpecification extends GenericSpecification<Designer, DesignerFilter> {

	private static final long serialVersionUID = -2742479818580132286L;
	
	private final DesignerFilter filter;

	@Override
	public Predicate toPredicate(Root<Designer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new Designer());

		return predicate;

	}

}
