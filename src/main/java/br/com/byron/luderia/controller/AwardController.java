package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.AwardFilter;
import br.com.byron.luderia.domain.mapper.IAwardMapper;
import br.com.byron.luderia.domain.request.AwardRequest;
import br.com.byron.luderia.domain.response.AwardResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Award;
import br.com.byron.luderia.repository.IAwardRepository;
import br.com.byron.luderia.repository.specification.AwardSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/award")
@Api(value = "Award")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = AwardResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class AwardController extends GenericController<Award, AwardFilter, AwardRequest, AwardResponse> {

	@Autowired
	public AwardController(ExecuteStrategy<Award> strategy, IAwardMapper mapper, IAwardRepository repository) {
		super(new Facade<Award, AwardFilter>(strategy, repository), mapper, new AwardSpecification());
	}

}
