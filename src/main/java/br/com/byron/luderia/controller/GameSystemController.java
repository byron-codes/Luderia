package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.GameSystemFilter;
import br.com.byron.luderia.dto.mapper.IGameSystemMapper;
import br.com.byron.luderia.dto.request.GameSystemRequest;
import br.com.byron.luderia.dto.response.GameSystemResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.GameSystem;
import br.com.byron.luderia.service.GameSystemService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/game-system")
@Api(value = "Game System")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = GameSystemResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class GameSystemController extends GenericController<GameSystem, GameSystemFilter, GameSystemRequest, GameSystemResponse> {

	@Autowired
	public GameSystemController(GameSystemService service, ExecuteStrategy<GameSystem> strategy, IGameSystemMapper mapper) {
		super(new Facade<GameSystem, GameSystemFilter>(service, strategy), mapper);
	}

}
