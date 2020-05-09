package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.CouponCodeFilter;
import br.com.byron.luderia.domain.filter.CouponFilter;
import br.com.byron.luderia.domain.request.CouponRequest;
import br.com.byron.luderia.domain.response.CouponResponse;
import br.com.byron.luderia.domain.model.Coupon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICouponMapper extends IGenericMapper<Coupon, CouponRequest, CouponResponse, CouponFilter>{

    public CouponCodeFilter toCodeFilter(String code);

}