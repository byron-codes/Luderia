package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.CompanyFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Company;
import br.com.byron.luderia.repository.ICompanyRepository;
import br.com.byron.luderia.repository.specification.CompanySpecification;

@Service
public class CompanyService extends GenericService<Company, CompanyFilter> {

	private ICompanyRepository repository;
	
	CompanyService(ICompanyRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Company> find(CompanyFilter filter) {
		List<Company> entities = repository.findAll(new CompanySpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
