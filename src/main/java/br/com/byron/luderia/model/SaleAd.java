package br.com.byron.luderia.model;

import java.time.LocalDate;
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
@Table(name = "_salead")
@ToString
public class SaleAd extends GenericEntity {

	@Column
	private Double value;
	
	@Column
	private LocalDate expirationDate;
	
	@Column
	private Integer quantity;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "product")
	private Product product;
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//	@OneToMany(mappedBy = "saleAd")
	private List<Comment> comments;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ProductState productState;
	
}
