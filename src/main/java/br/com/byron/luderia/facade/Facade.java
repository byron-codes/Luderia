package br.com.byron.luderia.facade;

import br.com.byron.luderia.domain.filter.GenericFilter;
import br.com.byron.luderia.domain.model.GenericEntity;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.repository.IGenericRepository;
import br.com.byron.luderia.repository.specification.GenericSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Facade<Entity extends GenericEntity, Filter extends GenericFilter> {

	private final ExecuteStrategy<Entity> strategy;

	private final IGenericRepository<Entity> repository;

	public List<Entity> find(GenericSpecification<Entity, Filter> specification) {
		return repository.findAll(specification);
	}

	public Entity save(Entity entity) throws NotFoundEntityException {
		strategy.save(entity);
		return repository.save(entity);
	}

	public Entity update(Entity entity) throws NotFoundEntityException {
		strategy.update(entity);
		return repository.save(entity);
	}

	public void delete(Entity entity) throws NotFoundEntityException {
		strategy.delete(entity);
		repository.save(entity);
	}

}
