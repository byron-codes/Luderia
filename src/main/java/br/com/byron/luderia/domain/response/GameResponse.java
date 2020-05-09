package br.com.byron.luderia.domain.response;

import br.com.byron.luderia.domain.model.GameLevel;
import br.com.byron.luderia.domain.model.GameStyle;
import br.com.byron.luderia.domain.model.GameType;
import br.com.byron.luderia.domain.model.LanguageDependence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
