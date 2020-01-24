package br.com.byron.luderia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemRequest extends GenericRequest {

	private Integer quantity;

	private Long adId;
	
}
