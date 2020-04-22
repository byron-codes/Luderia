package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.byron.luderia.dto.filter.CouponFilter;
import br.com.byron.luderia.dto.mapper.ICouponMapper;
import br.com.byron.luderia.dto.request.CouponRequest;
import br.com.byron.luderia.dto.response.CouponResponse;
import br.com.byron.luderia.facade.Facade;
import br.com.byron.luderia.model.Coupon;
import br.com.byron.luderia.service.CouponService;
import br.com.byron.luderia.strategy.ExecuteStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.time.LocalDate;

@RestController
@RequestMapping("/coupon")
@Api(value = "Coupon")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CouponResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CouponController extends GenericController<Coupon, CouponFilter, CouponRequest, CouponResponse> {

	private final ICouponMapper mapper;
	private final Facade<Coupon, CouponFilter> facade;

	@Autowired
	public CouponController(CouponService service, ExecuteStrategy<Coupon> strategy, ICouponMapper mapper) {
		super(new Facade<Coupon, CouponFilter>(service, strategy), mapper);
		this.mapper = mapper;
		this.facade = new Facade<Coupon, CouponFilter>(service, strategy);
	}

	@GetMapping("/code")
	public ResponseEntity<CouponResponse> addStock(@RequestParam String code) {
		return ResponseEntity.ok().body(mapper.toResponse(facade.find(mapper.toCodeFilter(code))).get(0));
	}

	@PutMapping("/{id}/quantity")
	public ResponseEntity<CouponResponse> addStock(@PathVariable("id") Long id, @RequestParam Integer quantity) {
		Coupon coupon = facade.find(mapper.toFilter(id)).get(0);
		coupon.setQuantity(coupon.getQuantity() + quantity);
		return ResponseEntity.ok().body(mapper.toResponse(facade.update(coupon)));
	}

}
