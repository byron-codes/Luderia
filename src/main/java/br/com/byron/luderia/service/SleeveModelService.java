package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.SleeveModelFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.SleeveModel;
import br.com.byron.luderia.repository.ISleeveModelRepository;
import br.com.byron.luderia.repository.specification.SleeveModelSpecification;

@Service
public class SleeveModelService extends GenericService<SleeveModel, SleeveModelFilter> {

	private ISleeveModelRepository repository;
	
	SleeveModelService(ISleeveModelRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<SleeveModel> find(SleeveModelFilter filter) {
		List<SleeveModel> entities = repository.findAll(new SleeveModelSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
