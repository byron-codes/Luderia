package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.DesignerFilter;
import br.com.byron.luderia.domain.mapper.IDesignerMapper;
import br.com.byron.luderia.domain.request.DesignerRequest;
import br.com.byron.luderia.domain.response.DesignerResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Designer;
import br.com.byron.luderia.repository.IDesignerRepository;
import br.com.byron.luderia.repository.specification.DesignerSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/designer")
@Api(value = "Designer")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = DesignerResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class DesignerController extends GenericController<Designer, DesignerFilter, DesignerRequest, DesignerResponse> {

	@Autowired
	public DesignerController(ExecuteStrategy<Designer> strategy, IDesignerMapper mapper, IDesignerRepository repository) {
		super(new Facade<Designer, DesignerFilter>(strategy, repository), mapper, new DesignerSpecification());
	}

}
