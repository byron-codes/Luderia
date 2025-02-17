package br.com.byron.luderia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "active=true")
@Table(name = "_image")
public class Image extends GenericEntity {

	@Column
	private String path;

	@Column
	private Integer size;

	@Column
	private String type;

	@Transient
	private String file;

}
