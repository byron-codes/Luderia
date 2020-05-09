package br.com.byron.luderia.domain.response;

import br.com.byron.luderia.domain.model.ChangeReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleChangeItemResponse extends GenericResponse {

	private Long id;

	private Integer quantity;

	private ChangeReason changeReason;

	private String description;

	private ProductResponse product;
	
}
