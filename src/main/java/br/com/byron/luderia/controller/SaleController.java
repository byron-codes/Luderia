package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.filter.UserFilter;
import br.com.byron.luderia.dto.mapper.IUserMapper;
import br.com.byron.luderia.dto.request.SaleStatusRequest;
import br.com.byron.luderia.dto.response.UserResponse;
import br.com.byron.luderia.model.SaleStatus;
import br.com.byron.luderia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.dto.mapper.ISaleMapper;
import br.com.byron.luderia.dto.request.SaleRequest;
import br.com.byron.luderia.dto.response.SaleResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.service.SaleService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

    @Autowired
    public SaleController(SaleService service, ExecuteStrategy<Sale> strategy, ISaleMapper mapper) {
        super(new Facade<Sale, SaleFilter>(service, strategy), mapper);
        facade = new Facade<Sale, SaleFilter>(service, strategy);
        this.mapper = mapper;
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<SaleResponse> addAddress(@PathVariable("id") Long id, @RequestBody SaleStatusRequest saleStatusRequest) {
        Sale sale = facade.find(mapper.toFilter(id)).get(0);
        sale.setSaleStatus(saleStatusRequest.getSaleStatus());
        return ResponseEntity.ok().body(mapper.toResponse(facade.update(sale)));
    }

    @Override
    public ResponseEntity<List<SaleResponse>> findAll(SaleFilter filter) {
        List<SaleResponse> sales = super.findAll(filter).getBody();
        sales.stream().forEach(sale -> sale.setCanChange(LocalDateTime.now().isBefore(sale.getDate().plusDays(15)) && sale.getSaleStatus() == SaleStatus.FINISHED));
        return ResponseEntity.ok(sales);
    }

	@Override
	public ResponseEntity<SaleResponse> findById(@PathVariable("id") Long id) {
		SaleResponse sale = super.findById(id).getBody();
		sale.setCanChange(LocalDateTime.now().isBefore(sale.getDate().plusDays(15)) && sale.getSaleStatus() == SaleStatus.FINISHED);
		return ResponseEntity.ok(sale);
	}

}
