package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.AccessoriesFilter;
import br.com.byron.luderia.domain.mapper.IAccessoriesMapper;
import br.com.byron.luderia.domain.request.AccessoriesRequest;
import br.com.byron.luderia.domain.response.AccessoriesResponse;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Accessories;
import br.com.byron.luderia.repository.IAccessoriesRepository;
import br.com.byron.luderia.repository.specification.AccessoriesSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/accessories")
@Api(value = "Accessories")
@ApiResponses({ @ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class AccessoriesController
		extends GenericController<Accessories, AccessoriesFilter, AccessoriesRequest, AccessoriesResponse> {

	private final Facade<Accessories, AccessoriesFilter> facade;

	private final IAccessoriesMapper mapper;

	private final AccessoriesSpecification accessoriesSpecification;

	public AccessoriesController(ExecuteStrategy<Accessories> strategy, IAccessoriesMapper mapper, IAccessoriesRepository repository) {
		super(new Facade<Accessories, AccessoriesFilter>(strategy, repository), mapper, new AccessoriesSpecification());
		facade = new Facade<Accessories, AccessoriesFilter>(strategy, repository);
		this.mapper = mapper;
		this.accessoriesSpecification = new AccessoriesSpecification();
	}

	@PutMapping("/{id}/stock")
	public ResponseEntity<AccessoriesResponse> addStock(@PathVariable("id") Long id, @RequestParam Integer quantity) throws NotFoundEntityException {
		accessoriesSpecification.setFilter(mapper.toFilter(id));
		Accessories accessories = facade.find(accessoriesSpecification).get(0);
		accessories.setQuantityStock(accessories.getQuantityStock() + quantity);
		accessories.setUpdateStock(LocalDate.now());
		return ResponseEntity.ok().body(mapper.toResponse(facade.update(accessories)));
	}

}
