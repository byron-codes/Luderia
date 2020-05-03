package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.AuthorFilter;
import br.com.byron.luderia.dto.mapper.IAuthorMapper;
import br.com.byron.luderia.dto.request.AuthorRequest;
import br.com.byron.luderia.dto.response.AuthorResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Author;
import br.com.byron.luderia.repository.IAuthorRepository;
import br.com.byron.luderia.repository.specification.AuthorSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@Api(value = "Author")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = AuthorResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class AuthorController extends GenericController<Author, AuthorFilter, AuthorRequest, AuthorResponse> {

	@Autowired
	public AuthorController(ExecuteStrategy<Author> strategy, IAuthorMapper mapper, IAuthorRepository repository) {
		super(new Facade<Author, AuthorFilter>(strategy, repository), mapper, new AuthorSpecification());
	}

}
