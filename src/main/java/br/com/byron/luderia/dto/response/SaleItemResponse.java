package br.com.byron.luderia.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemResponse extends GenericResponse {

	private Long id;

	private Integer quantity;

	private ProductResponse product;
	
}
