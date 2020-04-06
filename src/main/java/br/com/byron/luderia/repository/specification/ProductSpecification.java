package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.MechanicFilter;
import br.com.byron.luderia.dto.filter.ProductFilter;
import br.com.byron.luderia.model.Mechanic;
import br.com.byron.luderia.model.Product;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class ProductSpecification extends GenericSpecification<Product, ProductFilter> {
	
	private final ProductFilter filter;

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new Product());

		return predicate;

	}

}
