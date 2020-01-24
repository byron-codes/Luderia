package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.AddressFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Address;
import br.com.byron.luderia.repository.IAddressRepository;
import br.com.byron.luderia.repository.specification.AddressSpecification;

@Service
public class AddressService extends GenericService<Address, AddressFilter> {

	private IAddressRepository repository;
	
	AddressService(IAddressRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Address> find(AddressFilter filter) {
		List<Address> entities = repository.findAll(new AddressSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
