package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.CreditCardFilter;
import br.com.byron.luderia.model.Author;
import br.com.byron.luderia.model.CreditCard;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreditCardSpecification extends GenericSpecification<CreditCard, CreditCardFilter> {

    private static final long serialVersionUID = -5563730715436403078L;

    private final CreditCardFilter filter;

    @Override
    public Predicate toPredicate(Root<CreditCard> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        if (filter == null)
            return null;

        generateBasicPredicate(predicate, filter, root,
                criteriaBuilder, new CreditCard());

        return predicate;

    }

}
