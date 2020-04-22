package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.AccessoriesFilter;
import br.com.byron.luderia.dto.filter.ExpansionFilter;
import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.dto.mapper.IAccessoriesMapper;
import br.com.byron.luderia.dto.mapper.IExpansionMapper;
import br.com.byron.luderia.dto.mapper.IGameMapper;
import br.com.byron.luderia.dto.request.AccessoriesRequest;
import br.com.byron.luderia.dto.request.ExpansionRequest;
import br.com.byron.luderia.dto.response.AccessoriesResponse;
import br.com.byron.luderia.dto.response.ExpansionResponse;
import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Accessories;
import br.com.byron.luderia.model.Expansion;
import br.com.byron.luderia.model.Game;
import br.com.byron.luderia.service.AccessoriesService;
import br.com.byron.luderia.service.ExpansionService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

	public ExpansionController(ExpansionService service, ExecuteStrategy<Expansion> strategy, IExpansionMapper mapper) {
		super(new Facade<Expansion, ExpansionFilter>(service, strategy), mapper);
		facade = new Facade<Expansion, ExpansionFilter>(service, strategy);
		this.mapper = mapper;
	}

	@PutMapping("/{id}/stock")
	public ResponseEntity<ExpansionResponse> addStock(@PathVariable("id") Long id, @RequestParam Integer quantity) {
		Expansion expansion = facade.find(mapper.toFilter(id)).get(0);
		expansion.setQuantityStock(expansion.getQuantityStock() + quantity);
		expansion.setUpdateStock(LocalDate.now());
		return ResponseEntity.ok().body(mapper.toResponse(facade.update(expansion)));
	}

}
