package br.com.byron.luderia.strategy;

import br.com.byron.luderia.model.GenericEntity;

public interface IStrategy<Entity extends GenericEntity> {

	void execute(Entity entity);
	
}
