package br.com.byron.luderia.domain.validators.unique.cpf;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueCpfValidator.class})
public @interface UniqueCpf {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
