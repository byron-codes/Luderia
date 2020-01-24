package br.com.byron.luderia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "_coupon")
public class Coupon extends GenericEntity {
	
	@Column
	private String name;
	
	@Column
	private Double value;
	
	@Column
	private LocalDate expirationDate;
	
	@Column
	private Integer quatity;
	
	@Column
	private Integer usedQuatity;
	
}
