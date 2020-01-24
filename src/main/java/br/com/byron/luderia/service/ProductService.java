package br.com.byron.luderia.service;

import java.util.List;

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
		return repository.findAll();
	}

}
