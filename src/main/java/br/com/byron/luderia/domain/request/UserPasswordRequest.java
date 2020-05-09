package br.com.byron.luderia.domain.request;

import br.com.byron.luderia.domain.validators.equalsValidation.EqualFields;
import br.com.byron.luderia.domain.validators.oldPassword.OldPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualFields(baseField = "newPassword", matchField = "confirmPassword", message = "As senhas não são iguais")
@OldPassword(message = "A senha não é a correta")
public class UserPasswordRequest {

    private Long id;

    private String oldPassword;

    @NotBlank(message = "A senha não pode ser vazia")
    @Length(min = 5, max = 25,  message = "O tamanho da senha deve estar entre 5 e 25 caracteres")
    private String newPassword;

    private String confirmPassword;

}
