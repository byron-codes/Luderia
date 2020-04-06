package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.CouponCodeFilter;
import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.CouponFilter;
import br.com.byron.luderia.dto.request.CouponRequest;
import br.com.byron.luderia.dto.response.CouponResponse;
import br.com.byron.luderia.model.Coupon;

@Mapper(componentModel = "spring")
public interface ICouponMapper extends IGenericMapper<Coupon, CouponRequest, CouponResponse, CouponFilter>{

    public CouponCodeFilter toCodeFilter(String code);

}