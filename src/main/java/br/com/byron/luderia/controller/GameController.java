package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.GameFilter;
import br.com.byron.luderia.domain.mapper.IGameMapper;
import br.com.byron.luderia.domain.request.GameRequest;
import br.com.byron.luderia.domain.response.GameResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Game;
import br.com.byron.luderia.repository.IGameRepository;
import br.com.byron.luderia.repository.specification.GameSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/game")
@Api(value = "Game")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = GameResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class GameController extends GenericController<Game, GameFilter, GameRequest, GameResponse> {

    private final Facade<Game, GameFilter> facade;

    private final IGameMapper mapper;

    private final GameSpecification specification;

    @Autowired
    public GameController(ExecuteStrategy<Game> strategy, IGameMapper mapper, IGameRepository repository) {
        super(new Facade<Game, GameFilter>(strategy, repository), mapper, new GameSpecification());
        facade = new Facade<Game, GameFilter>(strategy, repository);
        this.mapper = mapper;
        specification = new GameSpecification();
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<GameResponse> addStock(@PathVariable("id") Long id, @RequestParam Integer quantity) {
        specification.setFilter(mapper.toFilter(id));
        Game game = facade.find(specification).get(0);
        game.setQuantityStock(game.getQuantityStock() + quantity);
        game.setUpdateStock(LocalDate.now());
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(game)));
    }

}
