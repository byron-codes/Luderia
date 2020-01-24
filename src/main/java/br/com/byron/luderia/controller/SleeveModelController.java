package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.SleeveModelFilter;
import br.com.byron.luderia.dto.mapper.ISleeveModelMapper;
import br.com.byron.luderia.dto.request.SleeveModelRequest;
import br.com.byron.luderia.dto.response.SleeveModelResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.SleeveModel;
import br.com.byron.luderia.service.SleeveModelService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sleeve-model")
@Api(value = "Sleeve Model")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = SleeveModelResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class SleeveModelController extends GenericController<SleeveModel, SleeveModelFilter, SleeveModelRequest, SleeveModelResponse> {

	@Autowired
	public SleeveModelController(SleeveModelService service, ExecuteStrategy<SleeveModel> strategy, ISleeveModelMapper mapper) {
		super(new Facade<SleeveModel, SleeveModelFilter>(service, strategy), mapper);
	}
	
}
