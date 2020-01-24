package br.com.byron.luderia.repository;

import org.springframework.stereotype.Repository;

import br.com.byron.luderia.model.User;

@Repository
public interface IUserRepository extends IGenericRepository<User> {

}
