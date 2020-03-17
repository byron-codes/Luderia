package br.com.byron.luderia.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.byron.luderia.dto.filter.LoginFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
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
        if (filter instanceof LoginFilter) {
            LoginFilter login = (LoginFilter) filter;
            Optional<User> user = repository.login(login.getNickname(), login.getPassword());
            if (user.isPresent()) {
                return Arrays.asList(user.get());
            }
            throw new NotFoundEntityException("Entity not found");
        }
        List<User> users = repository.findAll(new UserSpecification(filter));
        if (users.isEmpty()) {
            throw new NotFoundEntityException("Entity not found");
        }
        return users;
    }

}
