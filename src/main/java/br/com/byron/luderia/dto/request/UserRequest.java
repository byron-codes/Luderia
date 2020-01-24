package br.com.byron.luderia.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest extends GenericRequest {

	private String name;

	private String email;

	private String password;

	private String nickname;

	private String cpf;

	private List<AddressRequest> addresses;
	
	private List<CreditCardRequest> creditCards;
	
}
