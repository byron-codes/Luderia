package br.com.byron.luderia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.byron.luderia.model.Sale;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ISaleRepository extends IGenericRepository<Sale> {

    @Query("SELECT sale FROM Sale sale WHERE sale.creationDate BETWEEN :startDate AND :endDate")
    public List<Sale> getByPeriod(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
