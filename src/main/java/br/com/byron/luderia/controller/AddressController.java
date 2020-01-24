package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.AddressFilter;
import br.com.byron.luderia.dto.mapper.IAddressMapper;
import br.com.byron.luderia.dto.request.AddressRequest;
import br.com.byron.luderia.dto.response.AddressResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Address;
import br.com.byron.luderia.service.AddressService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
@Api(value = "Address")
@ApiResponses({ @ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class AddressController extends GenericController<Address, AddressFilter, AddressRequest, AddressResponse> {

	@Autowired
	public AddressController(AddressService service, ExecuteStrategy<Address> strategy, IAddressMapper mapper) {
		super(new Facade<Address, AddressFilter>(service, strategy), mapper);
	}

}
