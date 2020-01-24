package br.com.byron.luderia.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends GenericResponse {

	private Long id;
	
	private List<AddressResponse> addresses;
	
	private List<CreditCardResponse> creditCards;
	
	private List<CouponResponse> coupons;
	
}
