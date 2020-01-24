package br.com.byron.luderia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
	@Enumerated(EnumType.STRING)
	private UserType userType = UserType.COMMON;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CreditCard> creditCards;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Coupon> coupons;

}
