package br.com.byron.luderia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.AccessoriesFilter;
import br.com.byron.luderia.dto.mapper.IAccessoriesMapper;
import br.com.byron.luderia.dto.request.AccessoriesRequest;
import br.com.byron.luderia.dto.response.AccessoriesResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Accessories;
import br.com.byron.luderia.service.AccessoriesService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/accessories")
@Api(value = "Accessories")
@ApiResponses({ @ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class AccessoriesController
		extends GenericController<Accessories, AccessoriesFilter, AccessoriesRequest, AccessoriesResponse> {

	public AccessoriesController(AccessoriesService service, ExecuteStrategy<Accessories> strategy, IAccessoriesMapper mapper) {
		super(new Facade<Accessories, AccessoriesFilter>(service, strategy), mapper);
	}

}
