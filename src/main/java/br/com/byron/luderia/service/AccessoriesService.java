package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.AccessoriesFilter;
import br.com.byron.luderia.model.Accessories;
import br.com.byron.luderia.repository.IAccessoriesRepository;
import br.com.byron.luderia.repository.IGenericRepository;
import br.com.byron.luderia.repository.specification.AccessoriesSpecification;

@Service
public class AccessoriesService extends GenericService<Accessories, AccessoriesFilter> {

	private IAccessoriesRepository repository;
	
	AccessoriesService(IAccessoriesRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Accessories> find(AccessoriesFilter filter) {
		return repository.findAll(new AccessoriesSpecification(filter));
	}
	
	

}
