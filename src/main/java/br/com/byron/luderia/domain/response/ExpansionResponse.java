package br.com.byron.luderia.domain.response;

import br.com.byron.luderia.domain.model.GameLevel;
import br.com.byron.luderia.domain.model.LanguageDependence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpansionResponse extends ProductResponse {

	private String name;

	private String originalName;

	private String description;

	private LocalDate releaseDate;

	private Double value;

	private LanguageDependence languageDependence;

	private GameLevel level;

	private GameResponse baseGame;

}
