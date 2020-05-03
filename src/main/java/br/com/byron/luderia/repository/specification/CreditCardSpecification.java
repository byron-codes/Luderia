package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.CreditCardFilter;
import br.com.byron.luderia.model.CreditCard;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class CreditCardSpecification extends GenericSpecification<CreditCard, CreditCardFilter> {

    private static final long serialVersionUID = -5563730715436403078L;

    @Override
    public Predicate toPredicate(Root<CreditCard> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        if (getFilter() == null)
            return null;

        generateBasicPredicate(predicate, getFilter(), root,
                criteriaBuilder, new CreditCard());

        return predicate;

    }

}
