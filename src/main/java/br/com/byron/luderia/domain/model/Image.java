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
@Table(name = "_image")
@Where(clause = "active=true")
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
