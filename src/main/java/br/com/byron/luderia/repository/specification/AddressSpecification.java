package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.AddressFilter;
import br.com.byron.luderia.model.Address;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddressSpecification extends GenericSpecification<Address, AddressFilter> {

	private static final long serialVersionUID = -3798921289834329268L;
	
	private final AddressFilter filter;

	@Override
	public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
