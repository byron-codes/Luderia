package br.com.byron.luderia.domain.validators.unique.cpf;

import br.com.byron.luderia.domain.request.UserRequest;
import br.com.byron.luderia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCpfValidator implements ConstraintValidator<UniqueCpf, UserRequest> {

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean isValid(UserRequest user, ConstraintValidatorContext context) {
        try {
            if (userRepository.findByCpf(user.getCpf()).isPresent()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("O CPF já está cadastrado no sistema")
                        .addPropertyNode("cpf").addConstraintViolation();
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
