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
@Table(name = "_credit_card")
public class CreditCard extends GenericEntity {

	@Column
	private String name;
	
	@Column
	private String number;

	@Column
	private String cvv;

	@Column
	private String flag;

	@Column
	private String cpf;
	
	@Column
	private String nickname;

	@Column
	private Boolean favorite;

}
