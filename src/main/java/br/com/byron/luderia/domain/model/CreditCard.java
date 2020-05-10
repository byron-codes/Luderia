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
@Where(clause = "active=true")
public class CreditCard extends GenericEntity {

	@Column
	private String name;

	@Column
	private String number;

	@Column
	private String cvv;

	@Column
	private String expirationDate;

	@Column
	private String flag;

	@Column
	private String cpf;

	@Column
	private String nickname;

	@Column
	private Boolean favorite;

}
