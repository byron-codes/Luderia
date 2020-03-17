package br.com.byron.luderia.service;

import br.com.byron.luderia.dto.filter.MechanicFilter;
import br.com.byron.luderia.dto.filter.ProductFilter;
import br.com.byron.luderia.dto.filter.StateFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Mechanic;
import br.com.byron.luderia.model.Product;
import br.com.byron.luderia.model.State;
import br.com.byron.luderia.repository.IProductRepository;
import br.com.byron.luderia.repository.IStateRepository;
import br.com.byron.luderia.repository.specification.MechanicSpecification;
import br.com.byron.luderia.repository.specification.StateSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService extends GenericService<State, StateFilter> {

	private IStateRepository repository;

	StateService(IStateRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<State> find(StateFilter filter) {
		List<State> entities = repository.findAll(new StateSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
