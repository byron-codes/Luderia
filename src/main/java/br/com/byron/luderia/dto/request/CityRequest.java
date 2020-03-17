package br.com.byron.luderia.dto.request;

import br.com.byron.luderia.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityRequest extends GenericRequest {

	private Long id;
	
}
