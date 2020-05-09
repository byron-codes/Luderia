package br.com.byron.luderia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_address")
@Where(clause = "active=true")
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
