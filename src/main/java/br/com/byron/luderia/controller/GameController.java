package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.dto.mapper.IGameMapper;
import br.com.byron.luderia.dto.request.GameRequest;
import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Game;
import br.com.byron.luderia.service.GameService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/game")
@Api(value = "Game")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = GameResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class GameController extends GenericController<Game, GameFilter, GameRequest, GameResponse> {

	@Autowired
	public GameController(GameService service, ExecuteStrategy<Game> strategy, IGameMapper mapper) {
		super(new Facade<Game, GameFilter>(service, strategy), mapper);
	}
	
}
