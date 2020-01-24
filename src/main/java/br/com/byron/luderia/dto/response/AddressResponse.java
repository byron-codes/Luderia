package br.com.byron.luderia.dto.response;

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
	
	private CityResponse city;
	
}
