package br.com.byron.luderia.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse extends GenericResponse {

	private Long id;

	private String street;

	private Integer number;

	private String complement;

	private String neighborhood;

	private String cep;

	private CityResponse city;

	private StateResponse state;
	
}
