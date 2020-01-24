package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.UserFilter;
import br.com.byron.luderia.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserSpecification extends GenericSpecification<User, UserFilter> {

	private static final long serialVersionUID = 3161471407160571782L;
	
	private final UserFilter filter;

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
