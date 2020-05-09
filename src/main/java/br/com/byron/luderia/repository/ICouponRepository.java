package br.com.byron.luderia.repository;

import br.com.byron.luderia.domain.model.Coupon;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICouponRepository extends IGenericRepository<Coupon> {

    Optional<Coupon> findByCode(String code);

}
