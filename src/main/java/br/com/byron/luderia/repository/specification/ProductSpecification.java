package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.domain.filter.ProductFilter;
import br.com.byron.luderia.domain.model.Product;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ProductSpecification extends GenericSpecification<Product, ProductFilter> {

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        if (getFilter() == null)
            return null;

        generateBasicPredicate(predicate, getFilter(), root,
                criteriaBuilder, new Product());


        List<Predicate> orPredicate = new ArrayList<>();

        if (getFilter().getGame() != null && getFilter().getGame()) {
            orPredicate.add(criteriaBuilder.like(root.get("discriminator"), "GAME"));
        }

        if (getFilter().getAccessory() != null && getFilter().getAccessory()) {
            orPredicate.add(criteriaBuilder.like(root.get("discriminator"), "ACCESSORIES"));
        }

        if (getFilter().getExpansion() != null && getFilter().getExpansion()) {
            orPredicate.add(criteriaBuilder.like(root.get("discriminator"), "EXPANSION"));
        }

        //add(predicate, criteriaBuilder.or(orPredicate.toArray(new Predicate[orPredicate.size()])));

        //add(predicate, criteriaBuilder.or(orPredicate.toArray(new Predicate[orPredicate.size()])));

        return predicate;

    }

}
