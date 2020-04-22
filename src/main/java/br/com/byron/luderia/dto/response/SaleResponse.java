package br.com.byron.luderia.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import br.com.byron.luderia.model.Address;
import br.com.byron.luderia.model.CreditCard;
import br.com.byron.luderia.model.SaleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	private CreditCardResponse creditCard;

	private Boolean canChange;

}
