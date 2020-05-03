package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.SaleChangeItemFilter;
import br.com.byron.luderia.dto.mapper.ISaleChangeItemMapper;
import br.com.byron.luderia.dto.request.SaleChangeItemRequest;
import br.com.byron.luderia.dto.response.SaleChangeItemResponse;
import br.com.byron.luderia.dto.response.SaleResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.SaleChangeItem;
import br.com.byron.luderia.repository.ISaleChangeItemRepository;
import br.com.byron.luderia.repository.specification.SaleChangeItemSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale-change-item")
@Api(value = "Sale change item")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = SaleResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class SaleChangeItemController extends GenericController<SaleChangeItem, SaleChangeItemFilter, SaleChangeItemRequest, SaleChangeItemResponse> {

    private final Facade<SaleChangeItem, SaleChangeItemFilter> facade;

    private final ISaleChangeItemMapper mapper;

    private final SaleChangeItemSpecification specification;

    @Autowired
    public SaleChangeItemController(ExecuteStrategy<SaleChangeItem> strategy, ISaleChangeItemMapper mapper, ISaleChangeItemRepository repository) {
        super(new Facade<SaleChangeItem, SaleChangeItemFilter>(strategy, repository), mapper, new SaleChangeItemSpecification());
        facade = new Facade<SaleChangeItem, SaleChangeItemFilter>(strategy, repository);
        this.mapper = mapper;
        this.specification = new SaleChangeItemSpecification();
    }

    @PutMapping("/authorized/{id}/{status}")
    public ResponseEntity<Void> updateAuthorized(@PathVariable("status") Boolean status, @PathVariable("id") Long id) {
        specification.setFilter(mapper.toFilter(id));
        SaleChangeItem saleChangeItem = facade.find(specification).get(0);
        saleChangeItem.setAuthorized(status);
        facade.update(saleChangeItem);
        return ResponseEntity.noContent().build();
    }

}
