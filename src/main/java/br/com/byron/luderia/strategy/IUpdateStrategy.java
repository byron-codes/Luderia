package br.com.byron.luderia.strategy;

import java.util.List;
import java.util.Map;

import br.com.byron.luderia.model.GenericEntity;

public interface IUpdateStrategy<Entity extends GenericEntity> {

	public Map<String, List<String>> execute(Entity entity);

}
