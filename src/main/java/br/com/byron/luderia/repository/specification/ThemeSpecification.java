package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.ThemeFilter;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.model.Theme;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ThemeSpecification extends GenericSpecification<Theme, ThemeFilter> {

	private static final long serialVersionUID = 4891533662424415564L;
	
	private final ThemeFilter filter;

	@Override
	public Predicate toPredicate(Root<Theme> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new Theme());

		return predicate;

	}

}
