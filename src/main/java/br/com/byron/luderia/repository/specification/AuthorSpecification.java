package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.AuthorFilter;
import br.com.byron.luderia.model.Author;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorSpecification extends GenericSpecification<Author, AuthorFilter> {

	private static final long serialVersionUID = 3898290920006237089L;
	
	private final AuthorFilter filter;

	@Override
	public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
