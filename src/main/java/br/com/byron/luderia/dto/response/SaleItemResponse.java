package br.com.byron.luderia.dto.response;

import br.com.byron.luderia.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemResponse extends GenericResponse {

	private Long id;

	private Integer quantity;

	private ProductResponse product;
	
}
