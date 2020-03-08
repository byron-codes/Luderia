package br.com.byron.luderia.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "_address")
public class Address extends GenericEntity {

	@Column
	private String street;

	@Column
	private Integer number;

	@Column
	private String neighborhood;

	@Column
	private String complement;

	@Column
	private String cep;
	
	@Column
	private String nickname;
	
	@Column
	private Boolean favorite;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "city")
	private City city;
	
}
