package br.com.byron.luderia.repository;

import br.com.byron.luderia.model.SaleChange;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ISaleChangeRepository extends IGenericRepository<SaleChange> {

    @Query("SELECT change FROM SaleChange change WHERE change.creationDate BETWEEN :startDate AND :endDate")
    public List<SaleChange> getByPeriod(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
