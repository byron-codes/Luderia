package br.com.byron.luderia.domain.model;

import br.com.byron.luderia.domain.enumerable.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "active=true")
@Table(name = "_user")
public class User extends GenericEntity {

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private String nickname;

	@Column
	private String cpf;

	@Column
	private String actionToken;

	@Column
	private String expirationActionToken;

	@Column
	private String accessToken;

	@Column
	private String expirationAccessToken;

	@Column
	private Double balance = 0.0;

	@Column
	private Double salesValue = 0.0;

	@Column
	@Enumerated(EnumType.STRING)
	private UserType userType = UserType.COMMON;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CreditCard> creditCards;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Coupon> coupons;

}
