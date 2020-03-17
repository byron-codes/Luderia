package br.com.byron.luderia.service;

import br.com.byron.luderia.dto.filter.CityFilter;
import br.com.byron.luderia.dto.filter.StateFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.City;
import br.com.byron.luderia.model.State;
import br.com.byron.luderia.repository.ICityRepository;
import br.com.byron.luderia.repository.IStateRepository;
import br.com.byron.luderia.repository.specification.CitySpecification;
import br.com.byron.luderia.repository.specification.StateSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService extends GenericService<City, CityFilter> {

	private ICityRepository repository;

	CityService(ICityRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<City> find(CityFilter filter) {
		List<City> entities = repository.findAll(new CitySpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
