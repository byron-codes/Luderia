package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.GameCategoryFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.GameCategory;
import br.com.byron.luderia.repository.IGameCategoryRepository;
import br.com.byron.luderia.repository.specification.GameCategorySpecification;

@Service
public class GameCategoryService extends GenericService<GameCategory, GameCategoryFilter> {

	private IGameCategoryRepository repository;
	
	GameCategoryService(IGameCategoryRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<GameCategory> find(GameCategoryFilter filter) {
		List<GameCategory> entities = repository.findAll(new GameCategorySpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
