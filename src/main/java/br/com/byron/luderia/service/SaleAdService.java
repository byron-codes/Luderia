package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.SaleAdFilter;
import br.com.byron.luderia.model.SaleAd;
import br.com.byron.luderia.repository.ISaleAdRepository;
import br.com.byron.luderia.repository.specification.SaleAdSpecification;

@Service
public class SaleAdService extends GenericService<SaleAd, SaleAdFilter> {

	private ISaleAdRepository repository;
	
	SaleAdService(ISaleAdRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<SaleAd> find(SaleAdFilter filter) {
		return repository.findAll(new SaleAdSpecification(filter));
	}

}
