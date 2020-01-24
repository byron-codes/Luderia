package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.dto.mapper.ISaleMapper;
import br.com.byron.luderia.dto.request.SaleRequest;
import br.com.byron.luderia.dto.response.SaleResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.service.SaleService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sale")
@Api(value = "Sale")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = SaleResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class SaleController extends GenericController<Sale, SaleFilter, SaleRequest, SaleResponse> {

	@Autowired
	public SaleController(SaleService service, ExecuteStrategy<Sale> strategy, ISaleMapper mapper) {
		super(new Facade<Sale, SaleFilter>(service, strategy), mapper);
	}
	
}
