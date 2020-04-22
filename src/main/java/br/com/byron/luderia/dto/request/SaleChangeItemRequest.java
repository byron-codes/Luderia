package br.com.byron.luderia.dto.request;

import br.com.byron.luderia.dto.response.ProductResponse;
import br.com.byron.luderia.model.ChangeReason;
import br.com.byron.luderia.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
