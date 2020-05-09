package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.DesignerFilter;
import br.com.byron.luderia.domain.model.Designer;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class DesignerSpecification extends GenericSpecification<Designer, DesignerFilter> {

	private static final long serialVersionUID = -2742479818580132286L;

	@Override
	public Predicate toPredicate(Root<Designer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Designer());

		return predicate;

	}

}
