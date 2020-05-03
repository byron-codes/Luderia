package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.MechanicFilter;
import br.com.byron.luderia.dto.mapper.IMechanicMapper;
import br.com.byron.luderia.dto.request.MechanicRequest;
import br.com.byron.luderia.dto.response.MechanicResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Mechanic;
import br.com.byron.luderia.repository.IMechanicRepository;
import br.com.byron.luderia.repository.specification.MechanicSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mechanic")
@Api(value = "Mechanic")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = MechanicResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class MechanicController extends GenericController<Mechanic, MechanicFilter, MechanicRequest, MechanicResponse> {

	@Autowired
	public MechanicController(ExecuteStrategy<Mechanic> strategy, IMechanicMapper mapper, IMechanicRepository repository) {
		super(new Facade<Mechanic, MechanicFilter>(strategy, repository), mapper, new MechanicSpecification());
	}
	
}
