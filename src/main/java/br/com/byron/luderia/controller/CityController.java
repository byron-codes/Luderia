package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.CityFilter;
import br.com.byron.luderia.domain.mapper.ICityMapper;
import br.com.byron.luderia.domain.model.City;
import br.com.byron.luderia.domain.request.CityRequest;
import br.com.byron.luderia.domain.response.CityResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.repository.ICityRepository;
import br.com.byron.luderia.repository.specification.CitySpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
@Api(value = "City")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CityResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CityController extends GenericController<City, CityFilter, CityRequest, CityResponse> {

	@Autowired
	public CityController(ExecuteStrategy<City> strategy, ICityMapper mapper, ICityRepository repository) {
		super(new Facade<City, CityFilter>(strategy, repository), mapper, new CitySpecification());
	}

}
