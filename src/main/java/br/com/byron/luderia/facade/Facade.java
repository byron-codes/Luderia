package br.com.byron.luderia.facade;

import br.com.byron.luderia.dto.filter.GenericFilter;
import br.com.byron.luderia.model.GenericEntity;
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

	public Entity save(Entity entity) {
		strategy.save(entity);
		return repository.save(entity);
	}

	public Entity update(Entity entity) {
		strategy.update(entity);
		return repository.save(entity);
	}

	public void delete(Entity entity) {
		strategy.delete(entity);
		repository.save(entity);
	}

}
