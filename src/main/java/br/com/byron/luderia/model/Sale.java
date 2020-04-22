package br.com.byron.luderia.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_sale")
@ToString
@Where(clause = "active=true")
public class Sale extends GenericEntity {

	@Column
	private Double total;
	
	@Column
	private Double freight;
	
	@Column
	@Enumerated(EnumType.STRING)
	private SaleStatus saleStatus;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "buyer")
	private User buyer;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "address")
	private Address address;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "credit_card")
	private CreditCard creditCard;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "coupon")
	private Coupon coupon;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<SaleItem> items = new ArrayList<>();
	
}
