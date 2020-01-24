package br.com.byron.luderia.facade;

import java.util.List;

import br.com.byron.luderia.dto.filter.GenericFilter;
import br.com.byron.luderia.model.GenericEntity;
import br.com.byron.luderia.service.IGenericService;
import br.com.byron.luderia.strategy.ExecuteStrategy;

public class Facade<Entity extends GenericEntity, Filter extends GenericFilter> {

	private final IGenericService<Entity, Filter> service;

	private final ExecuteStrategy<Entity> strategy;

	public Facade(IGenericService<Entity, Filter> service, ExecuteStrategy<Entity> strategy) {
		this.service = service;
		this.strategy = strategy;
	}

	public List<Entity> find(Filter filter) {
		return service.find(filter);
	}

	public Entity save(Entity entity) {
		strategy.save(entity);
		return service.add(entity);
	}

	public Entity update(Entity entity) {
		strategy.update(entity);
		return service.update(entity);
	}

	public void delete(Entity entity) {
		strategy.delete(entity);
		service.delete(entity);
	}

}
