package br.com.byron.luderia.domain.validators.equalsValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class EqualFieldsValidator implements ConstraintValidator<EqualFields, Object> {

    private String baseField;
    private String matchField;

    @Override
    public void initialize(EqualFields constraint) {
        baseField = constraint.baseField();
        matchField = constraint.matchField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Object baseFieldValue = getFieldValue(object, baseField);
            Object matchFieldValue = getFieldValue(object, matchField);
            if(baseFieldValue == null || !baseFieldValue.equals(matchFieldValue)){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("As senhas não são iguais")
                        .addPropertyNode("confirmPassword").addConstraintViolation();
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
