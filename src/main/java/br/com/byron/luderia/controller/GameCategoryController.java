package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.GameCategoryFilter;
import br.com.byron.luderia.dto.mapper.IGameCategoryMapper;
import br.com.byron.luderia.dto.request.GameCategoryRequest;
import br.com.byron.luderia.dto.response.GameCategoryResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.GameCategory;
import br.com.byron.luderia.service.GameCategoryService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/game-category")
@Api(value = "Game Category")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = GameCategoryResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class GameCategoryController extends GenericController<GameCategory, GameCategoryFilter, GameCategoryRequest, GameCategoryResponse> {

	@Autowired
	public GameCategoryController(GameCategoryService service, ExecuteStrategy<GameCategory> strategy, IGameCategoryMapper mapper) {
		super(new Facade<GameCategory, GameCategoryFilter>(service, strategy), mapper);
	}

}
