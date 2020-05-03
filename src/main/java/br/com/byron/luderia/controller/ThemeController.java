package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.ThemeFilter;
import br.com.byron.luderia.dto.mapper.IThemeMapper;
import br.com.byron.luderia.dto.request.ThemeRequest;
import br.com.byron.luderia.dto.response.ThemeResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Theme;
import br.com.byron.luderia.repository.IThemeRepository;
import br.com.byron.luderia.repository.specification.ThemeSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theme")
@Api(value = "Theme")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = ThemeResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class ThemeController extends GenericController<Theme, ThemeFilter, ThemeRequest, ThemeResponse> {

	@Autowired
	public ThemeController(ExecuteStrategy<Theme> strategy, IThemeMapper mapper, IThemeRepository repository) {
		super(new Facade<Theme, ThemeFilter>(strategy, repository), mapper, new ThemeSpecification());
	}

}
