package br.com.byron.luderia.repository;

import br.com.byron.luderia.domain.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends IGenericRepository<Product> {

}
