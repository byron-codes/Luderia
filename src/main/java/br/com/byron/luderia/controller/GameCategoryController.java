package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.GameCategoryFilter;
import br.com.byron.luderia.domain.mapper.IGameCategoryMapper;
import br.com.byron.luderia.domain.request.GameCategoryRequest;
import br.com.byron.luderia.domain.response.GameCategoryResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.GameCategory;
import br.com.byron.luderia.repository.IGameCategoryRepository;
import br.com.byron.luderia.repository.specification.GameCategorySpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game-category")
@Api(value = "Game Category")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = GameCategoryResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class GameCategoryController extends GenericController<GameCategory, GameCategoryFilter, GameCategoryRequest, GameCategoryResponse> {

	@Autowired
	public GameCategoryController(ExecuteStrategy<GameCategory> strategy, IGameCategoryMapper mapper, IGameCategoryRepository repository) {
		super(new Facade<GameCategory, GameCategoryFilter>(strategy, repository), mapper, new GameCategorySpecification());
	}

}
