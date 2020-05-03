package br.com.byron.luderia.dto.request;

import br.com.byron.luderia.dto.validations.equalsValidation.EqualFields;
import br.com.byron.luderia.dto.validations.unique.cpf.UniqueCpf;
import br.com.byron.luderia.dto.validations.unique.email.UniqueEmail;
import br.com.byron.luderia.dto.validations.unique.nickname.UniqueNickname;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualFields(baseField = "password", matchField = "confirmPassword", message = "As senhas não são iguais")
@UniqueCpf(message = "O CPF já está cadastrado no sistema")
@UniqueNickname(message = "O nickname já está cadastrado no sistema")
@UniqueEmail(message = "O email já está cadastrado no sistema")
public class UserRequest extends GenericRequest {

	@NotBlank(message = "O nome não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho do nome deve estar entre 5 e 150 caracteres")
	private String name;

	@NotBlank(message = "O e-mail não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho do e-mail deve estar entre 5 e 150 caracteres")
	@Email(message = "E-mail inválido")
	private String email;

	@NotBlank(message = "A senha não pode ser vazia")
	@Length(min = 5, max = 25,  message = "O tamanho da senha deve estar entre 5 e 25 caracteres")
	private String password;

	private String confirmPassword;

	@NotBlank(message = "O nickname não pode ser vazio")
	@Length(min = 5, max = 25,  message = "O tamanho do nickname deve estar entre 5 e 25 caracteres")
	private String nickname;

	@NotBlank(message = "O CPF não pode ser vazio")
	@Length(min = 11, max = 11, message = "O CPF deve ter 11 caracteres")
	@CPF
	private String cpf;

	private List<AddressRequest> addresses;
	
	private List<CreditCardRequest> creditCards;
	
}
