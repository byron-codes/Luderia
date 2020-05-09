package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.AddressFilter;
import br.com.byron.luderia.domain.model.Address;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class AddressSpecification extends GenericSpecification<Address, AddressFilter> {

    private static final long serialVersionUID = -3798921289834329268L;

    @Override
    public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        if (getFilter() == null)
            return null;

        generateBasicPredicate(predicate, getFilter(), root,
                criteriaBuilder, new Address());

        return predicate;

    }

}
