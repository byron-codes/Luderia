package br.com.byron.luderia.dto.request;

import br.com.byron.luderia.model.ChangeReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleChangeItemRequest extends GenericRequest {

	private Long id;

	private Integer quantity;

	private ChangeReason changeReason;

	private String description;
	
}
