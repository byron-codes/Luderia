package br.com.byron.luderia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest extends GenericRequest {

	private LocalDateTime date;

	private Double freight;
	
	private IdRequest user;

	private IdRequest address;

	private List<IdRequest> creditCard;
	
	private IdRequest coupon;
	
	private List<SaleItemRequest> items;
	
}
