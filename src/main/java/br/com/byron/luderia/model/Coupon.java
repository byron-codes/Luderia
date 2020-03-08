package br.com.byron.luderia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_coupon")
@Where(clause = "active=true")
public class Coupon extends GenericEntity {
	
	@Column
	private String name;
	
	@Column
	private Double value;
	
	@Column
	private LocalDate expirationDate;
	
	@Column
	private Integer quantity;
	
	@Column
	private Integer usedQuatity;
	
	@Column
	private String code;

	@Column
	private String description;

}
