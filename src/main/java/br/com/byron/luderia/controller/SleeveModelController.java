package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.SleeveModelFilter;
import br.com.byron.luderia.dto.mapper.ISleeveModelMapper;
import br.com.byron.luderia.dto.request.SleeveModelRequest;
import br.com.byron.luderia.dto.response.SleeveModelResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.SleeveModel;
import br.com.byron.luderia.repository.ISleeveModelRepository;
import br.com.byron.luderia.repository.specification.SleeveModelSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sleeve-model")
@Api(value = "Sleeve Model")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = SleeveModelResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class SleeveModelController extends GenericController<SleeveModel, SleeveModelFilter, SleeveModelRequest, SleeveModelResponse> {

	@Autowired
	public SleeveModelController(ExecuteStrategy<SleeveModel> strategy, ISleeveModelMapper mapper, ISleeveModelRepository repository) {
		super(new Facade<SleeveModel, SleeveModelFilter>(strategy, repository), mapper, new SleeveModelSpecification());
	}
	
}
