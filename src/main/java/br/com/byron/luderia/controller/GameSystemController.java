package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.GameSystemFilter;
import br.com.byron.luderia.domain.mapper.IGameSystemMapper;
import br.com.byron.luderia.domain.request.GameSystemRequest;
import br.com.byron.luderia.domain.response.GameSystemResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.GameSystem;
import br.com.byron.luderia.repository.IGameSystemRepository;
import br.com.byron.luderia.repository.specification.GameSystemSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game-system")
@Api(value = "Game System")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = GameSystemResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class GameSystemController extends GenericController<GameSystem, GameSystemFilter, GameSystemRequest, GameSystemResponse> {

	@Autowired
	public GameSystemController(ExecuteStrategy<GameSystem> strategy, IGameSystemMapper mapper, IGameSystemRepository repository) {
		super(new Facade<GameSystem, GameSystemFilter>(strategy, repository), mapper, new GameSystemSpecification());
	}

}
