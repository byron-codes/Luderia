package br.com.byron.luderia.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest extends GenericRequest {

	private Long id;
	
	private String street;

	private Integer number;

	private String complement;

	private String neighborhood;

	private String cep;
	
	private String nickname;
	
	private Boolean favorite;
	
	private Long cityId;
	
}
