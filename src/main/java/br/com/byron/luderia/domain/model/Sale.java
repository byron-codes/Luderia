package br.com.byron.luderia.domain.model;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<CreditCard> creditCard;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "coupon")
	private Coupon coupon;
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<SaleItem> items = new ArrayList<>();
	
}
