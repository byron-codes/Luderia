package br.com.byron.luderia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.byron.luderia.model.GenericEntity;

@Repository
public interface IGenericRepository<Entity extends GenericEntity> extends JpaRepository<Entity, Long>, JpaSpecificationExecutor<Entity> {

}
