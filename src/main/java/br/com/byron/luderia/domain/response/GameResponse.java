package br.com.byron.luderia.domain.response;

import br.com.byron.luderia.domain.enumerable.GameLevel;
import br.com.byron.luderia.domain.enumerable.GameStyle;
import br.com.byron.luderia.domain.enumerable.GameType;
import br.com.byron.luderia.domain.enumerable.LanguageDependence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameResponse extends ProductResponse {

	private String name;

	private String originalName;

	private String description;

	private String components;

	private LocalDate releaseDate;

	private Integer minPlayers;

	private Integer maxPlayers;

	private Integer minMinutes;

	private Integer maxMinutes;

	private Integer minAge;

	private Boolean national;

	private Double avaliation;

	private Long companyId;

	private Long systemId;

	private Double value;

	private Integer quantityStock;

	private LanguageDependence languageDependence;

	private GameStyle style;

	private GameType type;

	private GameLevel level;

	private ImageResponse image;

}
