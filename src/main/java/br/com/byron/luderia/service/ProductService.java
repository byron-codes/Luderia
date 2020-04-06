package br.com.byron.luderia.service;

import java.util.List;

import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.repository.specification.ProductSpecification;
import br.com.byron.luderia.repository.specification.SaleSpecification;
import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.ProductFilter;
import br.com.byron.luderia.model.Product;
import br.com.byron.luderia.repository.IProductRepository;

@Service
public class ProductService extends GenericService<Product, ProductFilter> {

	private IProductRepository repository;

	ProductService(IProductRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Product> find(ProductFilter filter) {
		List<Product> entities = repository.findAll(new ProductSpecification(filter));
		if (entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
