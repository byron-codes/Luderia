package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.model.Game;
import br.com.byron.luderia.repository.IGameRepository;
import br.com.byron.luderia.repository.specification.GameSpecification;

@Service
public class GameService extends GenericService<Game, GameFilter> {

	private IGameRepository repository;
	
	GameService(IGameRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Game> find(GameFilter filter) {
		return repository.findAll(new GameSpecification(filter));
	}

}
