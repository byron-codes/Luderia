package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.AddressFilter;
import br.com.byron.luderia.domain.mapper.IAddressMapper;
import br.com.byron.luderia.domain.request.AddressRequest;
import br.com.byron.luderia.domain.response.AddressResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Address;
import br.com.byron.luderia.repository.IAddressRepository;
import br.com.byron.luderia.repository.specification.AddressSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@Api(value = "Address")
@ApiResponses({ @ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class AddressController extends GenericController<Address, AddressFilter, AddressRequest, AddressResponse> {

	@Autowired
	public AddressController(ExecuteStrategy<Address> strategy, IAddressMapper mapper, IAddressRepository repository) {
		super(new Facade<Address, AddressFilter>(strategy, repository), mapper, new AddressSpecification());
	}

}
