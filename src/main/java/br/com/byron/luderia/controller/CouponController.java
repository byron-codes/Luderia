package br.com.byron.luderia.controller;

import br.com.byron.luderia.domain.filter.CouponFilter;
import br.com.byron.luderia.domain.mapper.ICouponMapper;
import br.com.byron.luderia.domain.request.CouponRequest;
import br.com.byron.luderia.domain.response.CouponResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.domain.model.Coupon;
import br.com.byron.luderia.repository.ICouponRepository;
import br.com.byron.luderia.repository.specification.CouponSpecification;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
@Api(value = "Coupon")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CouponResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CouponController extends GenericController<Coupon, CouponFilter, CouponRequest, CouponResponse> {

	private final ICouponMapper mapper;

	private final Facade<Coupon, CouponFilter> facade;

	private final CouponSpecification specification;

	@Autowired
	public CouponController(ExecuteStrategy<Coupon> strategy, ICouponMapper mapper, ICouponRepository repository) {
		super(new Facade<Coupon, CouponFilter>(strategy, repository), mapper, new CouponSpecification());
		this.mapper = mapper;
		this.facade = new Facade<Coupon, CouponFilter>(strategy, repository);
		this.specification = new CouponSpecification();
	}

	@GetMapping("/code")
	public ResponseEntity<CouponResponse> addStock(@RequestParam String code) {
		specification.setFilter(mapper.toCodeFilter(code));
		return ResponseEntity.ok().body(mapper.toResponse(facade.find(specification).get(0)));
	}

	@PutMapping("/{id}/quantity")
	public ResponseEntity<CouponResponse> addStock(@PathVariable("id") Long id, @RequestParam Integer quantity) {
		specification.setFilter(mapper.toFilter(id));
		Coupon coupon = facade.find(specification).get(0);
		coupon.setQuantity(coupon.getQuantity() + quantity);
		return ResponseEntity.ok().body(mapper.toResponse(facade.update(coupon)));
	}

}
