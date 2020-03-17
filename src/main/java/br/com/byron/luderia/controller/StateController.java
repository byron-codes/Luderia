package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.CityFilter;
import br.com.byron.luderia.dto.filter.StateFilter;
import br.com.byron.luderia.dto.mapper.ICityMapper;
import br.com.byron.luderia.dto.mapper.IStateMapper;
import br.com.byron.luderia.dto.request.CityRequest;
import br.com.byron.luderia.dto.request.StateRequest;
import br.com.byron.luderia.dto.response.CityResponse;
import br.com.byron.luderia.dto.response.CompanyResponse;
import br.com.byron.luderia.dto.response.StateResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.City;
import br.com.byron.luderia.model.State;
import br.com.byron.luderia.service.CityService;
import br.com.byron.luderia.service.StateService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state")
@Api(value = "State")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CompanyResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class StateController extends GenericController<State, StateFilter, StateRequest, StateResponse> {

	@Autowired
	public StateController(StateService service, ExecuteStrategy<State> strategy, IStateMapper mapper) {
		super(new Facade<State, StateFilter>(service, strategy), mapper);
	}

}
