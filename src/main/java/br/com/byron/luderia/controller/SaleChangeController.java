package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.SaleChangeFilter;
import br.com.byron.luderia.domain.mapper.ISaleChangeMapper;
import br.com.byron.luderia.domain.request.SaleChangeRequest;
import br.com.byron.luderia.domain.response.SaleChangeResponse;
import br.com.byron.luderia.domain.response.SaleResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.ChangeStatus;
import br.com.byron.luderia.domain.model.SaleChange;
import br.com.byron.luderia.repository.ISaleChangeRepository;
import br.com.byron.luderia.repository.specification.SaleChangeSpecification;
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
@RequestMapping("/sale-change")
@Api(value = "Sale change")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = SaleResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class SaleChangeController extends GenericController<SaleChange, SaleChangeFilter, SaleChangeRequest, SaleChangeResponse> {

    private final Facade<SaleChange, SaleChangeFilter> facade;

    private final ISaleChangeMapper mapper;

    private final SaleChangeSpecification specification;

    @Autowired
    public SaleChangeController(ExecuteStrategy<SaleChange> strategy, ISaleChangeMapper mapper, ISaleChangeRepository repository) {
        super(new Facade<SaleChange, SaleChangeFilter>(strategy, repository), mapper, new SaleChangeSpecification());
        facade = new Facade<SaleChange, SaleChangeFilter>(strategy, repository);
        this.mapper = mapper;
        this.specification = new SaleChangeSpecification();
    }

    @PutMapping("/authorized/{id}")
    public ResponseEntity<Void> updateAuthorized(@PathVariable("id") Long id) {
        specification.setFilter(mapper.toFilter(id));
        SaleChange saleChange = facade.find(specification).get(0);
        saleChange.setChangeStatus(ChangeStatus.SHIPMENT);
        facade.update(saleChange);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/receive/{id}")
    public ResponseEntity<Void> updateReceive(@PathVariable("id") Long id) {
        specification.setFilter(mapper.toFilter(id));
        SaleChange saleChange = facade.find(specification).get(0);
        saleChange.setChangeStatus(ChangeStatus.FINISHED);
        facade.update(saleChange);
        return ResponseEntity.noContent().build();
    }

}
