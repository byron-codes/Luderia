package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.AuthorFilter;
import br.com.byron.luderia.domain.model.Author;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class AuthorSpecification extends GenericSpecification<Author, AuthorFilter> {

	private static final long serialVersionUID = 3898290920006237089L;

	@Override
	public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Author());

		return predicate;

	}

}
