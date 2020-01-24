package br.com.byron.luderia.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.luderia.model.GenericEntity;

@Component
public class ExecuteStrategy<Entity extends GenericEntity> {

	@Autowired
	List<ICreateStrategy<Entity>> saveStrategy;

	@Autowired
	List<IUpdateStrategy<Entity>> updateStrategy;

	@Autowired
	List<IDeleteStrategy<Entity>> deleteStrategy;

	public void save(Entity entity) {

//		Map<String, List<String>> errors = new HashMap<String, List<String>>();
//
//		for (ICreateStrategy<Entity> strategy : saveStrategy) {
//			errors.putAll(strategy.execute(entity));
//		}
//
//		if (!errors.isEmpty()) {
//			throw new StrategyException(errors, "An error occurred when strategies were executed");
//		}

	}

	public void update(Entity entity) {

//		Map<String, List<String>> errors = new HashMap<String, List<String>>();
//
//		for (IUpdateStrategy<Entity> strategy : updateStrategy) {
//			errors.putAll(strategy.execute(entity));
//		}
//
//		if (!errors.isEmpty()) {
//			throw new StrategyException(errors, "An error occurred when strategies were executed");
//		}

	}

	public void delete(Entity entity) {

//		Map<String, List<String>> errors = new HashMap<String, List<String>>();
//
//		for (IDeleteStrategy<Entity> strategy : deleteStrategy) {
//			errors.putAll(strategy.execute(entity));
//		}
//
//		if (!errors.isEmpty()) {
//			throw new StrategyException(errors, "An error occurred when strategies were executed");
//		}

	}

}
