package br.com.byron.luderia.repository;

import br.com.byron.luderia.domain.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends IGenericRepository<User> {

    @Query("SELECT user FROM User user WHERE user.nickname = :nickname AND user.password = :password")
    public Optional<User> login(@Param("nickname") String nickname, @Param("password") String password);

    public Optional<User> findByNickname(String nickname);

    public Optional<User> findByCpf(String cpf);

    public Optional<User> findByEmail(String email);

}
