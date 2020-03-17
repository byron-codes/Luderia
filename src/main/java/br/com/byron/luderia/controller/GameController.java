package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.dto.mapper.IGameMapper;
import br.com.byron.luderia.dto.request.GameRequest;
import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Game;
import br.com.byron.luderia.service.GameService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    @Autowired
    public GameController(GameService service, ExecuteStrategy<Game> strategy, IGameMapper mapper) {
        super(new Facade<Game, GameFilter>(service, strategy), mapper);
        facade = new Facade<Game, GameFilter>(service, strategy);
        this.mapper = mapper;
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<GameResponse> addStock(@PathVariable("id") Long id, @RequestParam Integer quantity) {
        Game game = facade.find(mapper.toFilter(id)).get(0);
        game.setQuantityStock(game.getQuantityStock() + quantity);
        game.setUpdateStock(LocalDate.now());
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(game)));
    }

    @GetMapping(path = "/{id}/imagem/")
    public ResponseEntity<byte[]> image(@PathVariable("id") Long gameId,
                                        @RequestParam(name = "largura", required = false, defaultValue = "1024") Integer largura,
                                        @RequestParam(name = "altura", required = false, defaultValue = "768") Integer altura) throws IOException {

        Game game = this.facade.find(mapper.toFilter(gameId)).get(0);

        if (game.getImage() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            headers.setContentType(MediaType.parseMediaType(game.getImage().getType()));
            headers.setContentLength(game.getImage().getSize());
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(Files.readAllBytes(Paths.get("c:/images/" + game.getImage().getId() + "." + game.getImage().getType().split("/")[1])), headers,
                    HttpStatus.OK);
            return responseEntity;
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            headers.setContentType(MediaType.parseMediaType("image/png"));
            headers.setContentLength(4778);
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(Files.readAllBytes(Paths.get("c:/images/notfound.png")), headers,
                    HttpStatus.OK);
            return responseEntity;
        }

    }
}
