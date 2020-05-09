package br.com.byron.luderia.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "product_discriminator")
@Table(name = "_product")
@Where(clause = "active=true")
public class Product extends GenericEntity {

	@Basic
	@Column(name = "product_discriminator", insertable = false, updatable = false)
	private String discriminator;

	@Column
	private String name;

	@Column
	private String description;
	
	@Column
	private Double value;
	
	@Column
	private Integer quantityStock = 0;
	
	@Column
	private LocalDate updateStock;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "image")
	private Image image;

}
