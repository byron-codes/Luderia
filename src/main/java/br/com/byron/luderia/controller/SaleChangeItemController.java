package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.SaleChangeFilter;
import br.com.byron.luderia.dto.filter.SaleChangeItemFilter;
import br.com.byron.luderia.dto.mapper.ISaleChangeItemMapper;
import br.com.byron.luderia.dto.mapper.ISaleChangeMapper;
import br.com.byron.luderia.dto.request.SaleChangeItemRequest;
import br.com.byron.luderia.dto.request.SaleChangeRequest;
import br.com.byron.luderia.dto.response.SaleChangeItemResponse;
import br.com.byron.luderia.dto.response.SaleChangeResponse;
import br.com.byron.luderia.dto.response.SaleResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.SaleChange;
import br.com.byron.luderia.model.SaleChangeItem;
import br.com.byron.luderia.service.SaleChangeItemService;
import br.com.byron.luderia.service.SaleChangeService;
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

    @Autowired
    public SaleChangeItemController(SaleChangeItemService service, ExecuteStrategy<SaleChangeItem> strategy, ISaleChangeItemMapper mapper) {
        super(new Facade<SaleChangeItem, SaleChangeItemFilter>(service, strategy), mapper);
        facade = new Facade<SaleChangeItem, SaleChangeItemFilter>(service, strategy);
        this.mapper = mapper;
    }

    @PutMapping("/authorized/{id}/{status}")
    public ResponseEntity<Void> updateAuthorized(@PathVariable("status") Boolean status, @PathVariable("id") Long id) {
        SaleChangeItem saleChangeItem = facade.find(mapper.toFilter(id)).get(0);
        saleChangeItem.setAuthorized(status);
        facade.update(saleChangeItem);
        return ResponseEntity.noContent().build();
    }

}
