package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.GameCategoryFilter;
import br.com.byron.luderia.model.GameCategory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameCategorySpecification extends GenericSpecification<GameCategory, GameCategoryFilter> {

    private static final long serialVersionUID = 7488675453393793530L;

    private final GameCategoryFilter filter;

    @Override
    public Predicate toPredicate(Root<GameCategory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        if (filter == null)
            return null;

        generateBasicPredicate(predicate, filter, root,
                criteriaBuilder, new GameCategory());

        return predicate;

    }

}
