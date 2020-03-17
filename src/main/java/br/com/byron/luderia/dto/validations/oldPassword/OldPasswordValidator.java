package br.com.byron.luderia.dto.validations.oldPassword;

import br.com.byron.luderia.dto.request.UserPasswordRequest;
import br.com.byron.luderia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class OldPasswordValidator implements ConstraintValidator<OldPassword, UserPasswordRequest> {

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean isValid(UserPasswordRequest user, ConstraintValidatorContext context) {
        try {
            if (userRepository.findById(user.getId()).get().getPassword() != user.getOldPassword()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("A senha não é a correta")
                        .addPropertyNode("oldPassword").addConstraintViolation();
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field passwordField = clazz.getDeclaredField(fieldName);
        passwordField.setAccessible(true);
        return passwordField.get(object);
    }

}
