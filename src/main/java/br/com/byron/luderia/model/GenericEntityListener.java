package br.com.byron.luderia.model;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GenericEntityListener {

	@PrePersist
	public void onPrePersist(GenericEntity entity) {
		entity.setActive(true);
		entity.setCreationDate(LocalDateTime.now());
		entity.setModifiedDate(LocalDateTime.now());
	}

	@PreUpdate
	public void onPreUpdate(GenericEntity entity) {
		if (entity.getActive() == null) {
			entity.setActive(true);
		}
		entity.setModifiedDate(LocalDateTime.now());
	}

}
