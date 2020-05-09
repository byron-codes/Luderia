package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.CompanyFilter;
import br.com.byron.luderia.domain.mapper.ICompanyMapper;
import br.com.byron.luderia.domain.request.CompanyRequest;
import br.com.byron.luderia.domain.response.CompanyResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Company;
import br.com.byron.luderia.repository.ICompanyRepository;
import br.com.byron.luderia.repository.specification.CompanySpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@Api(value = "Company")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CompanyResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CompanyController extends GenericController<Company, CompanyFilter, CompanyRequest, CompanyResponse> {

	@Autowired
	public CompanyController(ExecuteStrategy<Company> strategy, ICompanyMapper mapper, ICompanyRepository repository) {
		super(new Facade<Company, CompanyFilter>(strategy, repository), mapper, new CompanySpecification());
	}

}
