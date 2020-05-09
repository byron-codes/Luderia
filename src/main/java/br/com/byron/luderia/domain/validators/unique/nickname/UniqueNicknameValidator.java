package br.com.byron.luderia.domain.validators.unique.nickname;

import br.com.byron.luderia.domain.request.UserRequest;
import br.com.byron.luderia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNicknameValidator implements ConstraintValidator<UniqueNickname, UserRequest> {

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean isValid(UserRequest user, ConstraintValidatorContext context) {
        try {
            if (userRepository.findByNickname(user.getNickname()).isPresent()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("O nickname já está cadastrado no sistema")
                        .addPropertyNode("nickname").addConstraintViolation();
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
