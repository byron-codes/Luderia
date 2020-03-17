package br.com.byron.luderia.dto.validations.unique.email;

import br.com.byron.luderia.dto.request.UserRequest;
import br.com.byron.luderia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserRequest> {

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean isValid(UserRequest user, ConstraintValidatorContext context) {
        try {
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("O email já está cadastrado no sistema")
                        .addPropertyNode("email").addConstraintViolation();
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
