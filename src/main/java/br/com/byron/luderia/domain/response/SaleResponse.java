package br.com.byron.luderia.domain.response;

import br.com.byron.luderia.domain.model.SaleStatus;
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
public class SaleResponse extends GenericResponse {

	private Long id;
	
	private UserResponse buyer;
	
	private CouponResponse coupon;
	
	private List<SaleItemResponse> items;

	private LocalDateTime creationDate;

	private SaleStatus saleStatus;

	private Double total;

	private Double freight;

	private AddressResponse address;

	private List<CreditCardResponse> creditCard;

	private Boolean canChange;

}
