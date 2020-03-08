package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.AddressFilter;
import br.com.byron.luderia.dto.filter.CreditCardFilter;
import br.com.byron.luderia.dto.mapper.IAddressMapper;
import br.com.byron.luderia.dto.mapper.ICreditCardMapper;
import br.com.byron.luderia.dto.request.LoginRequest;
import br.com.byron.luderia.dto.request.UserPasswordRequest;
import br.com.byron.luderia.model.Address;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.service.AddressService;
import br.com.byron.luderia.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.byron.luderia.dto.filter.UserFilter;
import br.com.byron.luderia.dto.mapper.IUserMapper;
import br.com.byron.luderia.dto.request.UserRequest;
import br.com.byron.luderia.dto.response.UserResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.User;
import br.com.byron.luderia.service.UserService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api(value = "User")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = UserResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class UserController extends GenericController<User, UserFilter, UserRequest, UserResponse> {

    private final Facade<User, UserFilter> facade;

    private final Facade<CreditCard, CreditCardFilter> creditCardFacade;

    private final Facade<Address, AddressFilter> addressFacade;

    private final IUserMapper mapper;

    private final ICreditCardMapper creditCardMapper;

    private final IAddressMapper addressMapper;

    @Autowired
    public UserController(UserService service, ExecuteStrategy<User> strategy, IUserMapper mapper,
                          CreditCardService creditCardService, ExecuteStrategy<CreditCard> creditCardExecuteStrategy,
                          ICreditCardMapper creditCardMapper, AddressService addressService,
                          ExecuteStrategy<Address> addressExecuteStrategy, IAddressMapper addressMapper) {
        super(new Facade<User, UserFilter>(service, strategy), mapper);
        this.facade = new Facade<User, UserFilter>(service, strategy);
        this.creditCardFacade = new Facade<CreditCard, CreditCardFilter>(creditCardService, creditCardExecuteStrategy);
        this.addressFacade = new Facade<Address, AddressFilter>(addressService, addressExecuteStrategy);
        this.mapper = mapper;
        this.creditCardMapper = creditCardMapper;
        this.addressMapper = addressMapper;
    }

    @PutMapping("/password/{id}")
    public ResponseEntity<UserResponse> alterPassword(@Valid @RequestBody UserPasswordRequest request, @PathVariable("id") Long id) {
        User user = facade.find(mapper.toFilter(id)).get(0);
        user.setPassword(request.getPassword());
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(user)));
    }

    @PutMapping("/{id}/card/{idCard}")
    public ResponseEntity<UserResponse> addCard(@PathVariable("id") Long id, @PathVariable("idCard") Long idCard) {
        User user = facade.find(mapper.toFilter(id)).get(0);
        user.getCreditCards().add(creditCardFacade.find(creditCardMapper.toFilter(idCard)).get(0));
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(user)));
    }

    @PutMapping("/{id}/address/{idCard}")
    public ResponseEntity<UserResponse> addAddress(@PathVariable("id") Long id, @PathVariable("idCard") Long idAddress) {
        User user = facade.find(mapper.toFilter(id)).get(0);
        user.getAddresses().add(addressFacade.find(addressMapper.toFilter(idAddress)).get(0));
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(user)));
    }

    @GetMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid LoginRequest request) {
        return ResponseEntity.ok().body(mapper.toResponse(facade.find(mapper.fromLogin(request))).get(0));
    }

}
