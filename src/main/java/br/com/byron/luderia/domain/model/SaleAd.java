package br.com.byron.luderia.domain.model;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_salead")
@ToString
@Where(clause = "active=true")
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
