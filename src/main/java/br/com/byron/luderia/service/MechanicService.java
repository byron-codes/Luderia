package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.MechanicFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Mechanic;
import br.com.byron.luderia.repository.IMechanicRepository;
import br.com.byron.luderia.repository.specification.MechanicSpecification;

@Service
public class MechanicService extends GenericService<Mechanic, MechanicFilter> {

	private IMechanicRepository repository;
	
	MechanicService(IMechanicRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Mechanic> find(MechanicFilter filter) {
		List<Mechanic> entities = repository.findAll(new MechanicSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
