package br.com.byron.luderia.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(GenericEntityListener.class)
public class GenericEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = false)
	private LocalDateTime creationDate;

	@Column
	private String createdBy;

	@Column
	private LocalDateTime modifiedDate;

	@Column
	private String modifiedBy;

	@Column
	private Boolean active;

}
