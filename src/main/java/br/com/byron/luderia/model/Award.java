package br.com.byron.luderia.model;

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
@Table(name = "_award")
@Where(clause = "active=true")
public class Award extends GenericEntity {

	@Column
	private String name;
	
	@Column
	private Integer value;
	
	@Column
	private Integer year;
	
	public Award(Long id) {
		setId(id);
	}
	
}
