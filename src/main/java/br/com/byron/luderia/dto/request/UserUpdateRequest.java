package br.com.byron.luderia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest extends GenericRequest {

    @NotBlank(message = "O nome não pode ser vazio")
    @Length(min = 5, max = 150, message = "O tamanho do nome deve estar entre 5 e 150 caracteres")
    private String name;

    @NotBlank(message = "O e-mail não pode ser vazio")
    @Length(min = 5, max = 150, message = "O tamanho do e-mail deve estar entre 5 e 150 caracteres")
    @Email(message = "E-mail inválido")
    private String email;

}
