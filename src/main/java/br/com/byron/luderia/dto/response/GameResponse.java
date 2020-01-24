package br.com.byron.luderia.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameResponse extends ProductResponse {

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
