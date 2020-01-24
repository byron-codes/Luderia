package br.com.byron.luderia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardRequest extends GenericRequest {

	private Long id;
	
	private String name;
	
	private String number;

	private String cvv;

	private String flag;

	private String cpf;
	
	private String nickname;

	private Boolean favorite;
	
}
