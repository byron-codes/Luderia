package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.CreditCardFilter;
import br.com.byron.luderia.domain.mapper.ICreditCardMapper;
import br.com.byron.luderia.domain.request.CreditCardRequest;
import br.com.byron.luderia.domain.response.CreditCardResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.CreditCard;
import br.com.byron.luderia.repository.ICreditCardRepository;
import br.com.byron.luderia.repository.specification.CreditCardSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-card")
@Api(value = "Credit Card")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CreditCardResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CreditCardController extends GenericController<CreditCard, CreditCardFilter, CreditCardRequest, CreditCardResponse> {

	@Autowired
	public CreditCardController(ExecuteStrategy<CreditCard> strategy, ICreditCardMapper mapper, ICreditCardRepository repository) {
		super(new Facade<CreditCard, CreditCardFilter>(strategy, repository), mapper, new CreditCardSpecification());
	}

}
