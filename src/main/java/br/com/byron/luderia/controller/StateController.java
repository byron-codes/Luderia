package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.StateFilter;
import br.com.byron.luderia.domain.mapper.IStateMapper;
import br.com.byron.luderia.domain.model.State;
import br.com.byron.luderia.domain.request.StateRequest;
import br.com.byron.luderia.domain.response.StateResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.repository.IStateRepository;
import br.com.byron.luderia.repository.specification.StateSpecification;
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
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = StateResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class StateController extends GenericController<State, StateFilter, StateRequest, StateResponse> {

	@Autowired
	public StateController(ExecuteStrategy<State> strategy, IStateMapper mapper, IStateRepository repository) {
		super(new Facade<State, StateFilter>(strategy, repository), mapper, new StateSpecification());
	}

}
