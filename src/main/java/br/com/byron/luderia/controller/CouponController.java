package br.com.byron.luderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/coupon")
@Api(value = "Coupon")
@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = CouponResponse.class),
		@ApiResponse(code = 500, message = "Internal server error"),
		@ApiResponse(code = 400, message = "Bad request") })
public class CouponController extends GenericController<Coupon, CouponFilter, CouponRequest, CouponResponse> {

	@Autowired
	public CouponController(CouponService service, ExecuteStrategy<Coupon> strategy, ICouponMapper mapper) {
		super(new Facade<Coupon, CouponFilter>(service, strategy), mapper);
	}

}
