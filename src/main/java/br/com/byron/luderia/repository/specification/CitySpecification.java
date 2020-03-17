package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.AddressFilter;
import br.com.byron.luderia.dto.filter.CityFilter;
import br.com.byron.luderia.model.Address;
import br.com.byron.luderia.model.Author;
import br.com.byron.luderia.model.City;
import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class CitySpecification extends GenericSpecification<City, CityFilter> {

	private static final long serialVersionUID = -3798921289834329268L;
	
	private final CityFilter filter;

	@Override
	public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root,
				criteriaBuilder, new City());

		if(filter.getStateId() != null){
			add(predicate, criteriaBuilder.trim(root.get("state").get("id")).in(filter.getStateId()));
		}

		return predicate;

	}

}
