package br.com.byron.luderia.dto.response;

import br.com.byron.luderia.model.GameLevel;
import br.com.byron.luderia.model.GameStyle;
import br.com.byron.luderia.model.GameType;
import br.com.byron.luderia.model.LanguageDependence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

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
