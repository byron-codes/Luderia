package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.UserFilter;
import br.com.byron.luderia.domain.model.User;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class UserSpecification extends GenericSpecification<User, UserFilter> {

	private static final long serialVersionUID = 3161471407160571782L;

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new User());

		return predicate;

	}

}
