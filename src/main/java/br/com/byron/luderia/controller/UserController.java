package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.AddressFilter;
import br.com.byron.luderia.dto.filter.CreditCardFilter;
import br.com.byron.luderia.dto.filter.UserFilter;
import br.com.byron.luderia.dto.mapper.IAddressMapper;
import br.com.byron.luderia.dto.mapper.ICreditCardMapper;
import br.com.byron.luderia.dto.mapper.IUserMapper;
import br.com.byron.luderia.dto.request.LoginRequest;
import br.com.byron.luderia.dto.request.UserPasswordRequest;
import br.com.byron.luderia.dto.request.UserRequest;
import br.com.byron.luderia.dto.request.UserUpdateRequest;
import br.com.byron.luderia.dto.response.UserResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Address;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.model.User;
import br.com.byron.luderia.service.AddressService;
import br.com.byron.luderia.service.CreditCardService;
import br.com.byron.luderia.service.UserService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(value = "User")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = UserResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class UserController {

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
        this.facade = new Facade<User, UserFilter>(service, strategy);
        this.creditCardFacade = new Facade<CreditCard, CreditCardFilter>(creditCardService, creditCardExecuteStrategy);
        this.addressFacade = new Facade<Address, AddressFilter>(addressService, addressExecuteStrategy);
        this.mapper = mapper;
        this.creditCardMapper = creditCardMapper;
        this.addressMapper = addressMapper;
    }

    @PostMapping
    @ApiOperation(value = "Save", produces = "application/json", consumes = "application/json")
    @ApiResponse(code = 201, message = "Created")
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest entidadeRequest) {
        User e = facade.save(mapper.toEntity(entidadeRequest));
        return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.LOCATION, e.getId().toString())
                .body(mapper.toResponse(e));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find by id", produces = "application/json", consumes = "application/json")
    @ApiResponse(code = 404, message = "Not found")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toResponse(facade.find(mapper.toFilter(id)).get(0)));
    }

    @GetMapping
    @ApiOperation(value = "Find all with or without filter", produces = "application/json", consumes = "application/json")
    @ApiResponse(code = 404, message = "Not found")
    public ResponseEntity<List<UserResponse>> findAll(UserFilter filter) {
        return ResponseEntity.ok(mapper.toResponse(facade.find(filter)));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Not found") })
    public ResponseEntity<Void> update(@Valid @RequestBody UserUpdateRequest request, @PathVariable("id") Long id) {
        User user = facade.find(mapper.toFilter(id)).get(0);
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        facade.update(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @ApiOperation(value = "Delete", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Not found") })
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        facade.delete(mapper.toEntity(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/password/{id}")
    public ResponseEntity<UserResponse> alterPassword(@Valid @RequestBody UserPasswordRequest request, @PathVariable("id") Long id) {
        User user = facade.find(mapper.toFilter(id)).get(0);
        user.setPassword(request.getNewPassword());
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
