package br.com.byron.luderia.dto.response;

import br.com.byron.luderia.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

	private Double balance;
	
	private List<AddressResponse> addresses;
	
	private List<CreditCardResponse> creditCards;
	
	private List<CouponResponse> coupons;

	private Double salesValue;

	private UserType userType;
	
}
