package br.com.byron.luderia.repository;

import br.com.byron.luderia.domain.model.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenericRepository<Entity extends GenericEntity> extends JpaRepository<Entity, Long>, JpaSpecificationExecutor<Entity> {

}
