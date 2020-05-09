package br.com.byron.luderia.domain.validators.unique.nickname;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueNicknameValidator.class})
public @interface UniqueNickname {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
