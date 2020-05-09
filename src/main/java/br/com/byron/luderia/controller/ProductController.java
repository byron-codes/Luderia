package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.ProductFilter;
import br.com.byron.luderia.domain.mapper.IProductMapper;
import br.com.byron.luderia.domain.request.ProductRequest;
import br.com.byron.luderia.domain.response.GameResponse;
import br.com.byron.luderia.domain.response.ProductResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Product;
import br.com.byron.luderia.repository.IProductRepository;
import br.com.byron.luderia.repository.specification.ProductSpecification;
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

@RestController
@RequestMapping("/product")
@Api(value = "Product")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = GameResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class ProductController extends GenericController<Product, ProductFilter, ProductRequest, ProductResponse> {

    private final Facade<Product, ProductFilter> facade;

    private final IProductMapper mapper;

    private final ProductSpecification specification;

    @Autowired
    public ProductController(ExecuteStrategy<Product> strategy, IProductMapper mapper, IProductRepository repository) {
        super(new Facade<Product, ProductFilter>(strategy, repository), mapper, new ProductSpecification());
        facade = new Facade<Product, ProductFilter>(strategy, repository);
        this.mapper = mapper;
        this.specification = new ProductSpecification();
    }

    @GetMapping(path = "/{id}/image")
    public ResponseEntity<byte[]> image(@PathVariable("id") Long id,
                                        @RequestParam(name = "largura", required = false, defaultValue = "1024") Integer largura,
                                        @RequestParam(name = "altura", required = false, defaultValue = "768") Integer altura) throws IOException {

        specification.setFilter(mapper.toFilter(id));
        Product product = this.facade.find(specification).get(0);

        if (product.getImage().getPath() != null) {
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
