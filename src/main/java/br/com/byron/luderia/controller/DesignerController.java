package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.DesignerFilter;
import br.com.byron.luderia.dto.mapper.IDesignerMapper;
import br.com.byron.luderia.dto.request.DesignerRequest;
import br.com.byron.luderia.dto.response.DesignerResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Designer;
import br.com.byron.luderia.service.DesignerService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/designer")
@Api(value = "Designer")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = DesignerResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class DesignerController extends GenericController<Designer, DesignerFilter, DesignerRequest, DesignerResponse> {

	@Autowired
	public DesignerController(DesignerService service, ExecuteStrategy<Designer> strategy, IDesignerMapper mapper) {
		super(new Facade<Designer, DesignerFilter>(service, strategy), mapper);
	}

}
