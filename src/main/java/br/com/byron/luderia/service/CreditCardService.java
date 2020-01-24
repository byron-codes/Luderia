package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.CreditCardFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.repository.ICreditCardRepository;
import br.com.byron.luderia.repository.specification.CreditCardSpecification;

@Service
public class CreditCardService extends GenericService<CreditCard, CreditCardFilter> {

	private ICreditCardRepository repository;
	
	CreditCardService(ICreditCardRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<CreditCard> find(CreditCardFilter filter) {
		List<CreditCard> entities = repository.findAll(new CreditCardSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
