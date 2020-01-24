package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.CompanyFilter;
import br.com.byron.luderia.dto.mapper.ICompanyMapper;
import br.com.byron.luderia.dto.request.CompanyRequest;
import br.com.byron.luderia.dto.response.CompanyResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Company;
import br.com.byron.luderia.service.CompanyService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/company")
@Api(value = "Company")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CompanyResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CompanyController extends GenericController<Company, CompanyFilter, CompanyRequest, CompanyResponse> {

	@Autowired
	public CompanyController(CompanyService service, ExecuteStrategy<Company> strategy, ICompanyMapper mapper) {
		super(new Facade<Company, CompanyFilter>(service, strategy), mapper);
	}

}
