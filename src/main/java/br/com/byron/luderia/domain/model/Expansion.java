package br.com.byron.luderia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("EXPANSION")
@PrimaryKeyJoinColumn(name = "id_product")
@Table(name = "_expansion")
@Where(clause = "active=true")
public class Expansion extends Product {

	@Column
	private String name;

	@Column
	private String originalName;

	@Column
	private String description;

	@Column
	private LocalDate releaseDate;

	@Column
	@Enumerated(EnumType.STRING)
	private LanguageDependence languageDependence;

	@Column
	@Enumerated(EnumType.STRING)
	private GameLevel level;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "base_game")
	private Game baseGame;

}
