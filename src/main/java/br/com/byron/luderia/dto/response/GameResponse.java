package br.com.byron.luderia.dto.response;

import java.time.LocalDate;
import java.util.List;

import br.com.byron.luderia.model.GameLevel;
import br.com.byron.luderia.model.GameStyle;
import br.com.byron.luderia.model.GameType;
import br.com.byron.luderia.model.LanguageDependence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

	private List<AuthorResponse> authors;

	private List<AwardResponse> awards;

	private CompanyResponse company;

	private List<DesignerResponse> designers;

	private List<GameCategoryResponse> categories;

	private GameSystemResponse system;

	private ImageResponse image;

	private List<MechanicResponse> mechanics;

	private List<SleeveModelResponse> sleeves;

	private List<ThemeResponse> themes;

}
