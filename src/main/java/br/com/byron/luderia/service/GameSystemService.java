package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.GameSystemFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.GameSystem;
import br.com.byron.luderia.repository.IGameSystemRepository;
import br.com.byron.luderia.repository.specification.GameSystemSpecification;

@Service
public class GameSystemService extends GenericService<GameSystem, GameSystemFilter> {

	private IGameSystemRepository repository;
	
	GameSystemService(IGameSystemRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<GameSystem> find(GameSystemFilter filter) {
		List<GameSystem> entities = repository.findAll(new GameSystemSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
