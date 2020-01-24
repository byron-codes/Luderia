package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.luderia.dto.filter.CommentFilter;
import br.com.byron.luderia.dto.mapper.ICommentMapper;
import br.com.byron.luderia.dto.request.CommentRequest;
import br.com.byron.luderia.dto.response.CommentResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Comment;
import br.com.byron.luderia.service.CommentService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/comment")
@Api(value = "Comment")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CommentResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CommentController extends GenericController<Comment, CommentFilter, CommentRequest, CommentResponse> {

	@Autowired
	public CommentController(CommentService service, ExecuteStrategy<Comment> strategy, ICommentMapper mapper) {
		super(new Facade<Comment, CommentFilter>(service, strategy), mapper);
	}

}
