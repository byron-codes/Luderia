package br.com.byron.luderia.repository.specification;

import br.com.byron.luderia.dto.filter.CityFilter;
import br.com.byron.luderia.model.City;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor
public class CitySpecification extends GenericSpecification<City, CityFilter> {

	private static final long serialVersionUID = -3798921289834329268L;

	@Override
	public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (getFilter() == null)
			return null;

		generateBasicPredicate(predicate, getFilter(), root,
				criteriaBuilder, new City());

		if(getFilter().getStateId() != null){
			add(predicate, criteriaBuilder.trim(root.get("state").get("id")).in(getFilter().getStateId()));
		}

		return predicate;

	}

}
