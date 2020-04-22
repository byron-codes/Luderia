package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.ExpansionFilter;
import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.dto.request.ExpansionRequest;
import br.com.byron.luderia.dto.request.GameRequest;
import br.com.byron.luderia.dto.response.ExpansionResponse;
import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.model.Expansion;
import br.com.byron.luderia.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { IAwardMapper.class, IDesignerMapper.class, IAuthorMapper.class,
		IThemeMapper.class, IGameCategoryMapper.class, ISleeveModelMapper.class, IMechanicMapper.class })
public interface IExpansionMapper extends IGenericMapper<Expansion, ExpansionRequest, ExpansionResponse, ExpansionFilter> {

	@Mapping(source = "image", target = "image.file")
	@Mapping(source = "gameId", target = "baseGame.id")
	public Expansion toEntity(ExpansionRequest request);

	@Mapping(source = "resquest.image", target = "image.file")
	@Mapping(source = "resquest.gameId", target = "baseGame.id")
	public Expansion toUpdateEntity(ExpansionRequest resquest, Long id);
	
}
