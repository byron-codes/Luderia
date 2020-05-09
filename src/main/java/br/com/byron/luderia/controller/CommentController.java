package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.CommentFilter;
import br.com.byron.luderia.domain.mapper.ICommentMapper;
import br.com.byron.luderia.domain.request.CommentRequest;
import br.com.byron.luderia.domain.response.CommentResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Comment;
import br.com.byron.luderia.repository.ICommentRepository;
import br.com.byron.luderia.repository.specification.CommentSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@Api(value = "Comment")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CommentResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CommentController extends GenericController<Comment, CommentFilter, CommentRequest, CommentResponse> {

	@Autowired
	public CommentController(ExecuteStrategy<Comment> strategy, ICommentMapper mapper, ICommentRepository repository) {
		super(new Facade<Comment, CommentFilter>(strategy, repository), mapper, new CommentSpecification());
	}

}
