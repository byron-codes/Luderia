package br.com.byron.luderia.model;

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
@Table(name = "_sleeve")
public class SleeveModel extends GenericEntity {

	@Column
	private String name;

	@Column
	private Double mmHeight;

	@Column
	private Double mmWigth;

}
