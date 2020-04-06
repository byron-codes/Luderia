package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.dto.filter.ProductFilter;
import br.com.byron.luderia.dto.mapper.IGameMapper;
import br.com.byron.luderia.dto.mapper.IProductMapper;
import br.com.byron.luderia.dto.request.GameRequest;
import br.com.byron.luderia.dto.request.ProductRequest;
import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.dto.response.ProductResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Game;
import br.com.byron.luderia.model.Product;
import br.com.byron.luderia.service.GameService;
import br.com.byron.luderia.service.ProductService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

@RestController
@RequestMapping("/product")
@Api(value = "Product")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = GameResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class ProductController extends GenericController<Product, ProductFilter, ProductRequest, ProductResponse> {

    private final Facade<Product, ProductFilter> facade;

    private final IProductMapper mapper;

    @Autowired
    public ProductController(ProductService service, ExecuteStrategy<Product> strategy, IProductMapper mapper) {
        super(new Facade<Product, ProductFilter>(service, strategy), mapper);
        facade = new Facade<Product, ProductFilter>(service, strategy);
        this.mapper = mapper;
    }

    @GetMapping(path = "/{id}/image")
    public ResponseEntity<byte[]> image(@PathVariable("id") Long gameId,
                                        @RequestParam(name = "largura", required = false, defaultValue = "1024") Integer largura,
                                        @RequestParam(name = "altura", required = false, defaultValue = "768") Integer altura) throws IOException {

        Product product = this.facade.find(mapper.toFilter(gameId)).get(0);

        if (product.getImage() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            headers.setContentType(MediaType.parseMediaType(product.getImage().getType()));
            headers.setContentLength(product.getImage().getSize());
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(Files.readAllBytes(Paths.get("c:/images/" + product.getImage().getId() + "." + product.getImage().getType().split("/")[1])), headers,
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
