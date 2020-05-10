package br.com.byron.luderia.domain.request;

import br.com.byron.luderia.domain.enumerable.GameLevel;
import br.com.byron.luderia.domain.enumerable.LanguageDependence;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpansionRequest extends GenericRequest {

	@NotBlank(message = "O nome não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho do nome deve estar entre 5 e 150 caracteres")
	private String name;

	@NotBlank(message = "O nome original não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho do nome original deve estar entre 5 e 150 caracteres")
	private String originalName;

	@NotBlank(message = "A descrição não pode ser vazia")
	@Length(min = 5, max = 150, message = "O tamanho da descrição deve estar entre 5 e 150 caracteres")
	private String description;

	@NotNull(message = "A data de lançamento é obrigatória")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Past(message = "A data deve ser anterior a data atual")
	private LocalDate releaseDate;

	@NotNull(message = "O valor do jogo não pode ser vazio")
	@Positive(message = "O valor do jogo deve ser positivo")
	private Double value;

	@NotNull(message = "A dependência de linguagem não pode ser vazia")
	private LanguageDependence languageDependence;

	@NotNull(message = "A dificuldade do jogo não pode ser vazia")
	private GameLevel level;

	@NotNull(message = "O jogo base é obrigatório")
	private Long gameId;

	private String image;
	
}
