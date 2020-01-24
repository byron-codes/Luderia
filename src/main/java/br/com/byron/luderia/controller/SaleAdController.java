package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.SaleAdFilter;
import br.com.byron.luderia.dto.mapper.ISaleAdMapper;
import br.com.byron.luderia.dto.request.SaleAdRequest;
import br.com.byron.luderia.dto.response.SaleAdResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.SaleAd;
import br.com.byron.luderia.service.SaleAdService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sale-ad")
@Api(value = "Sale Ad")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = SaleAdResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class SaleAdController extends GenericController<SaleAd, SaleAdFilter, SaleAdRequest, SaleAdResponse> {

	@Autowired
	public SaleAdController(SaleAdService service, ExecuteStrategy<SaleAd> strategy, ISaleAdMapper mapper) {
		super(new Facade<SaleAd, SaleAdFilter>(service, strategy), mapper);
	}
	
}
