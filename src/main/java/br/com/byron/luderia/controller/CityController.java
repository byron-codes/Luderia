package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.CityFilter;
import br.com.byron.luderia.dto.filter.CompanyFilter;
import br.com.byron.luderia.dto.mapper.ICityMapper;
import br.com.byron.luderia.dto.mapper.ICompanyMapper;
import br.com.byron.luderia.dto.request.CityRequest;
import br.com.byron.luderia.dto.request.CompanyRequest;
import br.com.byron.luderia.dto.response.CityResponse;
import br.com.byron.luderia.dto.response.CompanyResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.City;
import br.com.byron.luderia.model.Company;
import br.com.byron.luderia.service.CityService;
import br.com.byron.luderia.service.CompanyService;
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
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CompanyResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CityController extends GenericController<City, CityFilter, CityRequest, CityResponse> {

	@Autowired
	public CityController(CityService service, ExecuteStrategy<City> strategy, ICityMapper mapper) {
		super(new Facade<City, CityFilter>(service, strategy), mapper);
	}

}
