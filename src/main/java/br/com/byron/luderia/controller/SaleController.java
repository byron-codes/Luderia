package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.dto.mapper.ISaleMapper;
import br.com.byron.luderia.dto.request.SaleRequest;
import br.com.byron.luderia.dto.request.SaleStatusRequest;
import br.com.byron.luderia.dto.response.SaleResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.model.SaleStatus;
import br.com.byron.luderia.repository.ISaleRepository;
import br.com.byron.luderia.repository.specification.SaleSpecification;
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
@RequestMapping("/sale")
@Api(value = "Sale")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = SaleResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class SaleController extends GenericController<Sale, SaleFilter, SaleRequest, SaleResponse> {

    private final Facade<Sale, SaleFilter> facade;

    private final ISaleMapper mapper;

    private final SaleSpecification specification;

    @Autowired
    public SaleController(ExecuteStrategy<Sale> strategy, ISaleMapper mapper, ISaleRepository repository) {
        super(new Facade<Sale, SaleFilter>(strategy, repository), mapper, new SaleSpecification());
        facade = new Facade<Sale, SaleFilter>(strategy, repository);
        this.mapper = mapper;
        this.specification = new SaleSpecification();
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<SaleResponse> addAddress(@PathVariable("id") Long id, @RequestBody SaleStatusRequest saleStatusRequest) {
        specification.setFilter(mapper.toFilter(id));
        Sale sale = facade.find(specification).get(0);
        sale.setSaleStatus(saleStatusRequest.getSaleStatus());
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(sale)));
    }

    @Override
    public ResponseEntity<List<SaleResponse>> findAll(SaleFilter filter) {
        List<SaleResponse> sales = super.findAll(filter).getBody();
        sales.stream().forEach(sale -> sale.setCanChange(LocalDateTime.now().isBefore(sale.getCreationDate().plusDays(15)) && sale.getSaleStatus() == SaleStatus.FINISHED));
        return ResponseEntity.ok(sales);
    }

	@Override
	public ResponseEntity<SaleResponse> findById(@PathVariable("id") Long id) {
		SaleResponse sale = super.findById(id).getBody();
		sale.setCanChange(LocalDateTime.now().isBefore(sale.getCreationDate().plusDays(15)) && sale.getSaleStatus() == SaleStatus.FINISHED);
		return ResponseEntity.ok(sale);
	}

}
