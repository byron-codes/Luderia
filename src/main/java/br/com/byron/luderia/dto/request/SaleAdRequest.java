package br.com.byron.luderia.dto.request;

import br.com.byron.luderia.model.ProductState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleAdRequest extends GenericRequest {

	private Double value;
	
	private LocalDate expirationDate;
	
	private Integer quantity;
	
	private ProductRequest product;
	
	private ProductState productState;
	
}
