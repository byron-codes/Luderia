package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.AwardFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Award;
import br.com.byron.luderia.repository.IAwardRepository;
import br.com.byron.luderia.repository.specification.AwardSpecification;

@Service
public class AwardService extends GenericService<Award, AwardFilter> {

	private IAwardRepository repository;
	
	AwardService(IAwardRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Award> find(AwardFilter filter) {
		List<Award> entities = repository.findAll(new AwardSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
