package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.GenericFilter;
import br.com.byron.luderia.dto.mapper.IGenericMapper;
import br.com.byron.luderia.dto.request.GenericRequest;
import br.com.byron.luderia.dto.response.GenericResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.GenericEntity;
import br.com.byron.luderia.repository.specification.GenericSpecification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@Api(value = "CRUD")
@ApiResponses({ 
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class GenericController<Entity extends GenericEntity, Filter extends GenericFilter, Request extends GenericRequest, Response extends GenericResponse> {

	private final Facade<Entity, Filter> facade;

	private final IGenericMapper<Entity, Request, Response, Filter> mapper;

	private final GenericSpecification<Entity, Filter> specification;
	
	@PostMapping
	@ApiOperation(value = "Save", produces = "application/json", consumes = "application/json")
	@ApiResponse(code = 201, message = "Created")
	public ResponseEntity<Response> save(@Valid @RequestBody Request entidadeRequest) {
		Entity e = facade.save(mapper.toEntity(entidadeRequest));
		return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.LOCATION, e.getId().toString())
				.body(mapper.toResponse(e));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find by id", produces = "application/json", consumes = "application/json")
	@ApiResponse(code = 404, message = "Not found")
	public ResponseEntity<Response> findById(@PathVariable("id") Long id) {
		specification.setFilter(mapper.toFilter(id));
		return ResponseEntity.ok(mapper.toResponse(facade.find(specification).get(0)));
	}

	@GetMapping
	@ApiOperation(value = "Find all with or without filter", produces = "application/json", consumes = "application/json")
	@ApiResponse(code = 404, message = "Not found")
	public ResponseEntity<List<Response>> findAll(Filter filter) {
		specification.setFilter(filter);
		return ResponseEntity.ok(mapper.toResponse(facade.find(specification)));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update", produces = "application/json", consumes = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Success"),
			@ApiResponse(code = 404, message = "Not found") })
	public ResponseEntity<Void> update(@Valid @RequestBody Request request, @PathVariable("id") Long id) {
		facade.update(mapper.toUpdateEntity(request, id));
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

}
