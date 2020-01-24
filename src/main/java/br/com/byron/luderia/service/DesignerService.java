package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.DesignerFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Designer;
import br.com.byron.luderia.repository.IDesignerRepository;
import br.com.byron.luderia.repository.specification.DesignerSpecification;

@Service
public class DesignerService extends GenericService<Designer, DesignerFilter> {

	private IDesignerRepository repository;
	
	DesignerService(IDesignerRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Designer> find(DesignerFilter filter) {
		List<Designer> entities = repository.findAll(new DesignerSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
