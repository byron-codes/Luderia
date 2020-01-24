package br.com.byron.luderia.dto.request;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.byron.luderia.model.GameLevel;
import br.com.byron.luderia.model.GameStyle;
import br.com.byron.luderia.model.GameType;
import br.com.byron.luderia.model.LanguageDependence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameRequest extends GenericRequest {

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

	private MultipartFile image;

	private Long systemId;

	private LanguageDependence languageDependence;

	private GameStyle style;

	private GameType type;

	private GameLevel level;

	private List<Long> awards;

	private List<Long> designers;

	private List<Long> authors;

	private List<Long> themes;

	private List<Long> categories;

	private List<Long> sleeves;

	private List<Long> mechanics;
	
}
