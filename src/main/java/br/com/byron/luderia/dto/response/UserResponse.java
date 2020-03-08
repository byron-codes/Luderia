package br.com.byron.luderia.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends GenericResponse {

	private Long id;

	private String name;

	private String email;

	private String password;

	private String nickname;

	private String cpf;
	
	private List<AddressResponse> addresses;
	
	private List<CreditCardResponse> creditCards;
	
	private List<CouponResponse> coupons;
	
}
