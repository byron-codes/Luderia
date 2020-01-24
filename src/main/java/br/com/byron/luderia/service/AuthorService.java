package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.AuthorFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.Author;
import br.com.byron.luderia.repository.IAuthorRepository;
import br.com.byron.luderia.repository.specification.AuthorSpecification;

@Service
public class AuthorService extends GenericService<Author, AuthorFilter> {

	private IAuthorRepository repository;
	
	AuthorService(IAuthorRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<Author> find(AuthorFilter filter) {
		List<Author> entities = repository.findAll(new AuthorSpecification(filter));
		if(entities.isEmpty()) {
			throw new NotFoundEntityException("Entity not found");
		}
		return entities;
	}

}
