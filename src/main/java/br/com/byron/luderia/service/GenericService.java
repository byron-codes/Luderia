package br.com.byron.luderia.service;

import br.com.byron.luderia.dto.filter.GenericFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.GenericEntity;
import br.com.byron.luderia.repository.IGenericRepository;

public abstract class GenericService<Entity extends GenericEntity, Filter extends GenericFilter> implements IGenericService<Entity, Filter>{

	private final IGenericRepository<Entity> repository;
	
	GenericService(IGenericRepository<Entity> repository){
		this.repository = repository;
	}
	
	public Entity add(Entity entity) {
		return repository.saveAndFlush(entity);
	}

	public Entity update(Entity entity) {
		find(entity);
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Entity entity) {
		find(entity);
		entity.setActive(false);
		repository.saveAndFlush(entity);
	}
	
	public Entity find(Entity request) {
		return repository.findById(request.getId()).orElseThrow(() -> new NotFoundEntityException("Entity nor found"));
	}

}
