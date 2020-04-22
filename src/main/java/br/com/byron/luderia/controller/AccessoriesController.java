package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.ExpansionFilter;
import br.com.byron.luderia.dto.mapper.IExpansionMapper;
import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.model.Expansion;
import br.com.byron.luderia.model.Game;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import br.com.byron.luderia.dto.filter.AccessoriesFilter;
import br.com.byron.luderia.dto.mapper.IAccessoriesMapper;
import br.com.byron.luderia.dto.request.AccessoriesRequest;
import br.com.byron.luderia.dto.response.AccessoriesResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Accessories;
import br.com.byron.luderia.service.AccessoriesService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

	public AccessoriesController(AccessoriesService service, ExecuteStrategy<Accessories> strategy, IAccessoriesMapper mapper) {
		super(new Facade<Accessories, AccessoriesFilter>(service, strategy), mapper);
		facade = new Facade<Accessories, AccessoriesFilter>(service, strategy);
		this.mapper = mapper;
	}

	@PutMapping("/{id}/stock")
	public ResponseEntity<AccessoriesResponse> addStock(@PathVariable("id") Long id, @RequestParam Integer quantity) {
		Accessories accessories = facade.find(mapper.toFilter(id)).get(0);
		accessories.setQuantityStock(accessories.getQuantityStock() + quantity);
		accessories.setUpdateStock(LocalDate.now());
		return ResponseEntity.ok().body(mapper.toResponse(facade.update(accessories)));
	}

}
