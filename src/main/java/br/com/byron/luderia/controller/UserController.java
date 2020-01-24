package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/user")
@Api(value = "User")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = UserResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class UserController extends GenericController<User, UserFilter, UserRequest, UserResponse> {

	@Autowired
	public UserController(UserService service, ExecuteStrategy<User> strategy, IUserMapper mapper) {
		super(new Facade<User, UserFilter>(service, strategy), mapper);
	}

}
