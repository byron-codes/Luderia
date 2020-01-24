package br.com.byron.luderia.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_sale")
@ToString
public class Sale extends GenericEntity {

	@Column
	private Double total;
	
	@Column
	private Double sendValue;
	
	@Column
	private LocalDateTime date;
	
	@Column
	@Enumerated(EnumType.STRING)
	private SaleStatus saleStatus;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "buyer")
	private User buyer;
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Coupon> coupons = new ArrayList<Coupon>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SaleItem> items = new ArrayList<SaleItem>();
	
}
