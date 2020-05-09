package br.com.byron.luderia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_sleeve")
@Where(clause = "active=true")
public class SleeveModel extends GenericEntity {

	@Column
	private String name;

	@Column
	private Double mmHeight;

	@Column
	private Double mmWigth;

}
