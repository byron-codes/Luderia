package br.com.byron.luderia.model;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

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
	private Integer quantityStock;
	
	@Column
	private LocalDate updateStock;

}
