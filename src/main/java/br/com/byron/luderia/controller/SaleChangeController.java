package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.SaleChangeFilter;
import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.dto.mapper.ISaleChangeMapper;
import br.com.byron.luderia.dto.mapper.ISaleMapper;
import br.com.byron.luderia.dto.request.SaleChangeRequest;
import br.com.byron.luderia.dto.request.SaleRequest;
import br.com.byron.luderia.dto.request.SaleStatusRequest;
import br.com.byron.luderia.dto.response.SaleChangeResponse;
import br.com.byron.luderia.dto.response.SaleResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.*;
import br.com.byron.luderia.service.SaleChangeService;
import br.com.byron.luderia.service.SaleService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sale-change")
@Api(value = "Sale change")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = SaleResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class SaleChangeController extends GenericController<SaleChange, SaleChangeFilter, SaleChangeRequest, SaleChangeResponse> {

    private final Facade<SaleChange, SaleChangeFilter> facade;

    private final ISaleChangeMapper mapper;

    @Autowired
    public SaleChangeController(SaleChangeService service, ExecuteStrategy<SaleChange> strategy, ISaleChangeMapper mapper) {
        super(new Facade<SaleChange, SaleChangeFilter>(service, strategy), mapper);
        facade = new Facade<SaleChange, SaleChangeFilter>(service, strategy);
        this.mapper = mapper;
    }

    @PutMapping("/authorized/{id}")
    public ResponseEntity<Void> updateAuthorized(@PathVariable("id") Long id) {
        SaleChange saleChange = facade.find(mapper.toFilter(id)).get(0);
        saleChange.setChangeStatus(ChangeStatus.SHIPMENT);
        facade.update(saleChange);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/receive/{id}")
    public ResponseEntity<Void> updateReceive(@PathVariable("id") Long id) {
        SaleChange saleChange = facade.find(mapper.toFilter(id)).get(0);
        saleChange.setChangeStatus(ChangeStatus.FINISHED);
        facade.update(saleChange);
        return ResponseEntity.noContent().build();
    }

}
