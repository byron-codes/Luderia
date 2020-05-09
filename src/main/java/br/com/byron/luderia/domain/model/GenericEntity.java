package br.com.byron.luderia.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
