package br.com.byron.luderia.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest extends GenericRequest {

	private LocalDateTime date;

	private Double freight;
	
	private IdRequest user;

	private IdRequest address;

	private IdRequest creditCard;
	
	private IdRequest coupon;
	
	private List<SaleItemRequest> items;
	
}
