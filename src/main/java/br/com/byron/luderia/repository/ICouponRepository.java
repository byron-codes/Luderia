package br.com.byron.luderia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.byron.luderia.model.Coupon;

import java.util.Optional;

@Repository
public interface ICouponRepository extends IGenericRepository<Coupon> {

    Optional<Coupon> findByCode(String code);

}
