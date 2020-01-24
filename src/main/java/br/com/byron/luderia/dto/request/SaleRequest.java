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
	
	private Long userId;
	
	private List<Long> coupons;
	
	private List<SaleItemRequest> items;
	
}
