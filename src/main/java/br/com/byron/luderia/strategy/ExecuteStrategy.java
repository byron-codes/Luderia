package br.com.byron.luderia.strategy;

import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.domain.model.GenericEntity;
import br.com.byron.luderia.repository.IGenericRepository;
import br.com.byron.luderia.utils.StrategyOrder;
import br.com.byron.luderia.utils.StrategyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ExecuteStrategy<Entity extends GenericEntity> {

    private final Map<String, IStrategy> strategies;

    private final Map<String, IGenericRepository<Entity>> repository;

    private final StrategyOrder strategyOrder = new StrategyOrder();

    public void save(Entity entity) throws NotFoundEntityException {
        List<String> strategyList = strategyOrder.getSaveOrder().get(entity.getClass().getSimpleName());
        if (strategyList != null) {
            for (String strategy : strategyList) {
                strategies.get(strategy).execute(entity);
            }
        }
    }

    public void update(Entity entity) throws NotFoundEntityException {
        List<String> strategyList = strategyOrder.getUpdateOrder().get(entity.getClass().getSimpleName());
        if (strategyList != null) {
            for (String strategy : strategyList) {
                strategies.get(strategy).execute(entity);
            }
        }
    }

    public void delete(Entity entity) throws NotFoundEntityException {
        repository.get(StrategyUtils.formatRepositoryName(entity.getClass())).findById(entity.getId()).orElseThrow(() -> new NotFoundEntityException("Entity nor found"));
        entity.setActive(false);
    }



}
