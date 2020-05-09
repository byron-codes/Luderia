package br.com.byron.luderia.repository;

import br.com.byron.luderia.domain.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
}
