package br.com.byron.luderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.UserFilter;
import br.com.byron.luderia.model.User;
import br.com.byron.luderia.repository.IUserRepository;
import br.com.byron.luderia.repository.specification.UserSpecification;

@Service
public class UserService extends GenericService<User, UserFilter> {

	private IUserRepository repository;
	
	UserService(IUserRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<User> find(UserFilter filter) {
		return repository.findAll(new UserSpecification(filter));
	}

}
