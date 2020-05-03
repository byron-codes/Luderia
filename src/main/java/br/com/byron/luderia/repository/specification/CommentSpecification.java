package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.CommentFilter;
import br.com.byron.luderia.model.Comment;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class CommentSpecification extends GenericSpecification<Comment, CommentFilter> {

	private static final long serialVersionUID = -5693794552668077976L;

	@Override
	public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new Comment());

		return predicate;

	}

}
