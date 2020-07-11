package br.com.byron.luderia.strategy;

import br.com.byron.luderia.domain.model.GenericEntity;
import br.com.byron.luderia.exception.NotFoundEntityException;

public interface IStrategy<Entity extends GenericEntity> {

	void execute(Entity entity) throws NotFoundEntityException;
	
}
