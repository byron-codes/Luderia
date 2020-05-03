package br.com.byron.luderia.dto.request;

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
public class GameRequest extends GenericRequest {

	@NotBlank(message = "O nome não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho do nome deve estar entre 5 e 150 caracteres")
	private String name;

	@NotBlank(message = "O nome original não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho do nome original deve estar entre 5 e 150 caracteres")
	private String originalName;

	@NotBlank(message = "A descrição não pode ser vazia")
	@Length(min = 5, max = 150, message = "O tamanho da descrição deve estar entre 5 e 150 caracteres")
	private String description;

	private String components;

	@NotNull(message = "A data de lançamento é obrigatória")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Past(message = "A data deve ser anterior a data atual")
	private LocalDate releaseDate;

	@NotNull(message = "O número minímo de jogadores não pode ser vazio")
	@Positive(message = "O número minímo de jogadores deve ser posivito")
	private Integer minPlayers;

	@NotNull(message = "O número máximo de jogadores não pode ser vazio")
	@Positive(message = "O número máximo de jogadores deve ser posivito")
	private Integer maxPlayers;

	@NotNull(message = "O número minímo de minutos não pode ser vazio")
	@Positive(message = "O número minímo de minutos deve ser posivito")
	private Integer minMinutes;

	@NotNull(message = "O número máximo de minutos não pode ser vazio")
	@Positive(message = "O número máximo de minutos deve ser posivito")
	private Integer maxMinutes;

	@NotNull(message = "O idade miníma não pode ser vazia")
	@Positive(message = "O idade miníma deve ser posivita")
	private Integer minAge;

	private Boolean national;

	private Double avaliation;

	private Long companyId;

	private String image;

	private Long systemId;

	@NotNull(message = "A dependência de linguagem não pode ser vazia")
	private LanguageDependence languageDependence;

	@NotNull(message = "O estilo de jogo não pode ser vazio")
	private GameStyle style;

	@NotNull(message = "O tipo de jogo não pode ser vazio")
	private GameType type;

	@NotNull(message = "A dificuldade do jogo não pode ser vazia")
	private GameLevel level;

	@NotNull(message = "O valor do jogo não pode ser vazio")
	@Positive(message = "O valor do jogo deve ser positivo")
	private Double value;

	private Integer quantityStock = 0;

	private List<Long> awards;

	private List<Long> designers;

	private List<Long> authors;

	private List<Long> themes;

	private List<Long> categories;

	private List<Long> sleeves;

	private List<Long> mechanics;
	
}
