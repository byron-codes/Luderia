package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.ExpansionFilter;
import br.com.byron.luderia.domain.mapper.IExpansionMapper;
import br.com.byron.luderia.domain.request.ExpansionRequest;
import br.com.byron.luderia.domain.response.ExpansionResponse;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Expansion;
import br.com.byron.luderia.repository.IExpansionRepository;
import br.com.byron.luderia.repository.specification.ExpansionSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/expansion")
@Api(value = "Expansion")
@ApiResponses({ @ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class ExpansionController
		extends GenericController<Expansion, ExpansionFilter, ExpansionRequest, ExpansionResponse> {

	private final Facade<Expansion, ExpansionFilter> facade;

	private final IExpansionMapper mapper;

	private final ExpansionSpecification specification;

	public ExpansionController(ExecuteStrategy<Expansion> strategy, IExpansionMapper mapper, IExpansionRepository repository) {
		super(new Facade<Expansion, ExpansionFilter>(strategy, repository), mapper, new ExpansionSpecification());
		facade = new Facade<Expansion, ExpansionFilter>(strategy, repository);
		this.mapper = mapper;
		this.specification = new ExpansionSpecification();
	}

	@PutMapping("/{id}/stock")
	public ResponseEntity<ExpansionResponse> addStock(@PathVariable("id") Long id, @RequestParam Integer quantity) throws NotFoundEntityException {
		specification.setFilter(mapper.toFilter(id));
		Expansion expansion = facade.find(specification).get(0);
		expansion.setQuantityStock(expansion.getQuantityStock() + quantity);
		expansion.setUpdateStock(LocalDate.now());
		return ResponseEntity.ok().body(mapper.toResponse(facade.update(expansion)));
	}

}
