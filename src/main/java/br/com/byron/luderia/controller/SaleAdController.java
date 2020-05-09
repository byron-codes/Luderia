package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.SaleAdFilter;
import br.com.byron.luderia.domain.mapper.ISaleAdMapper;
import br.com.byron.luderia.domain.request.SaleAdRequest;
import br.com.byron.luderia.domain.response.SaleAdResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.SaleAd;
import br.com.byron.luderia.repository.ISaleAdRepository;
import br.com.byron.luderia.repository.specification.SaleAdSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale-ad")
@Api(value = "Sale Ad")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = SaleAdResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class SaleAdController extends GenericController<SaleAd, SaleAdFilter, SaleAdRequest, SaleAdResponse> {

	@Autowired
	public SaleAdController(ExecuteStrategy<SaleAd> strategy, ISaleAdMapper mapper, ISaleAdRepository repository) {
		super(new Facade<SaleAd, SaleAdFilter>(strategy, repository), mapper, new SaleAdSpecification());
	}
	
}
