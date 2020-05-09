package br.com.byron.luderia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

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
	private Integer usedQuatity = 0;
	
	@Column
	private String code;

	@Column
	private String description;

}
