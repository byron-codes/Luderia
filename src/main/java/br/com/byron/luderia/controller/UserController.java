package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.AddressFilter;
import br.com.byron.luderia.domain.filter.CreditCardFilter;
import br.com.byron.luderia.domain.filter.UserFilter;
import br.com.byron.luderia.domain.mapper.IAddressMapper;
import br.com.byron.luderia.domain.mapper.ICreditCardMapper;
import br.com.byron.luderia.domain.mapper.IUserMapper;
import br.com.byron.luderia.domain.request.LoginRequest;
import br.com.byron.luderia.domain.request.UserPasswordRequest;
import br.com.byron.luderia.domain.request.UserRequest;
import br.com.byron.luderia.domain.request.UserUpdateRequest;
import br.com.byron.luderia.domain.response.UserResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Address;
import br.com.byron.luderia.domain.model.CreditCard;
import br.com.byron.luderia.domain.model.User;
import br.com.byron.luderia.repository.IAddressRepository;
import br.com.byron.luderia.repository.ICreditCardRepository;
import br.com.byron.luderia.repository.IUserRepository;
import br.com.byron.luderia.repository.specification.AddressSpecification;
import br.com.byron.luderia.repository.specification.CreditCardSpecification;
import br.com.byron.luderia.repository.specification.UserSpecification;
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

    private final UserSpecification specification;

    private final AddressSpecification addressSpecification;

    private final CreditCardSpecification creditCardSpecification;

    @Autowired
    public UserController(ExecuteStrategy<User> strategy, IUserMapper mapper,
                          ExecuteStrategy<CreditCard> creditCardExecuteStrategy,
                          ICreditCardMapper creditCardMapper,
                          ExecuteStrategy<Address> addressExecuteStrategy, IAddressMapper addressMapper,
                          IUserRepository repository, ICreditCardRepository creditCardRepository,
                          IAddressRepository addressRepository) {
        this.facade = new Facade<User, UserFilter>(strategy, repository);
        this.creditCardFacade = new Facade<CreditCard, CreditCardFilter>(creditCardExecuteStrategy, creditCardRepository);
        this.addressFacade = new Facade<Address, AddressFilter>(addressExecuteStrategy, addressRepository);
        this.mapper = mapper;
        this.creditCardMapper = creditCardMapper;
        this.addressMapper = addressMapper;
        this.specification = new UserSpecification();
        this.addressSpecification = new AddressSpecification();
        this.creditCardSpecification = new CreditCardSpecification();
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
        specification.setFilter(mapper.toFilter(id));
        return ResponseEntity.ok(mapper.toResponse(facade.find(specification).get(0)));
    }

    @GetMapping
    @ApiOperation(value = "Find all with or without filter", produces = "application/json", consumes = "application/json")
    @ApiResponse(code = 404, message = "Not found")
    public ResponseEntity<List<UserResponse>> findAll(UserFilter filter) {
        specification.setFilter(filter);
        return ResponseEntity.ok(mapper.toResponse(facade.find(specification)));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Not found") })
    public ResponseEntity<Void> update(@Valid @RequestBody UserUpdateRequest request, @PathVariable("id") Long id) {
        specification.setFilter(mapper.toFilter(id));
        User user = facade.find(specification).get(0);
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
        specification.setFilter(mapper.toFilter(id));
        User user = facade.find(specification).get(0);
        user.setPassword(request.getNewPassword());
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(user)));
    }

    @PutMapping("/{id}/card/{idCard}")
    public ResponseEntity<UserResponse> addCard(@PathVariable("id") Long id, @PathVariable("idCard") Long idCard) {
        specification.setFilter(mapper.toFilter(id));
        creditCardSpecification.setFilter(creditCardMapper.toFilter(idCard));
        User user = facade.find(specification).get(0);
        user.getCreditCards().add(creditCardFacade.find(creditCardSpecification).get(0));
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(user)));
    }

    @PutMapping("/{id}/address/{idAddress}")
    public ResponseEntity<UserResponse> addAddress(@PathVariable("id") Long id, @PathVariable("idAddress") Long idAddress) {
        specification.setFilter(mapper.toFilter(id));
        addressSpecification.setFilter(addressMapper.toFilter(idAddress));
        User user = facade.find(specification).get(0);
        user.getAddresses().add(addressFacade.find(addressSpecification).get(0));
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(user)));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest request) {
        specification.setFilter(request);
        return ResponseEntity.ok().body(mapper.toResponse(facade.find(specification).get(0)));
    }

}
