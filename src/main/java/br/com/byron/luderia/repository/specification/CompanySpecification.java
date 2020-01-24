package br.com.byron.luderia.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.byron.luderia.dto.filter.CompanyFilter;
import br.com.byron.luderia.model.Company;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanySpecification extends GenericSpecification<Company, CompanyFilter> {

	private static final long serialVersionUID = 3671519219523852170L;
	
	private final CompanyFilter filter;

	@Override
	public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder);

		return predicate;

	}

}
