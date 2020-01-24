package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.CreditCardFilter;
import br.com.byron.luderia.dto.mapper.ICreditCardMapper;
import br.com.byron.luderia.dto.request.CreditCardRequest;
import br.com.byron.luderia.dto.response.CreditCardResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.service.CreditCardService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/credit-card")
@Api(value = "Credit Card")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CreditCardResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CreditCardController extends GenericController<CreditCard, CreditCardFilter, CreditCardRequest, CreditCardResponse> {

	@Autowired
	public CreditCardController(CreditCardService service, ExecuteStrategy<CreditCard> strategy, ICreditCardMapper mapper) {
		super(new Facade<CreditCard, CreditCardFilter>(service, strategy), mapper);
	}

}
