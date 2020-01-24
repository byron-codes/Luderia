package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.CommentFilter;
import br.com.byron.luderia.model.Comment;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentSpecification extends GenericSpecification<Comment, CommentFilter> {

	private static final long serialVersionUID = -5693794552668077976L;
	
	private final CommentFilter filter;

	@Override
	public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
