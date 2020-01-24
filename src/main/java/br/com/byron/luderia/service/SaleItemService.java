package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.SaleItemFilter;
import br.com.byron.luderia.model.SaleItem;
import br.com.byron.luderia.repository.ISaleItemRepository;

@Service
public class SaleItemService extends GenericService<SaleItem, SaleItemFilter>{

	private ISaleItemRepository repository;
	
	SaleItemService(ISaleItemRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<SaleItem> find(SaleItemFilter filter) {
		return repository.findAll();
	}

}
