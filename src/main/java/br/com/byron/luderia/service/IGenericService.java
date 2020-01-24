package br.com.byron.luderia.service;

import java.util.List;

import br.com.byron.luderia.dto.filter.GenericFilter;
import br.com.byron.luderia.model.GenericEntity;

public interface IGenericService<Entity extends GenericEntity, Filter extends GenericFilter>{

	public Entity add(Entity entity);
	
	public Entity update(Entity entity);
	
	public Entity find(Entity request);
	
	public List<Entity> find(Filter filter);
	
	public void delete(Entity entity);
	
}
