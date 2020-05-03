package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.dto.request.GameRequest;
import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { IAwardMapper.class, IDesignerMapper.class, IAuthorMapper.class,
		IThemeMapper.class, IGameCategoryMapper.class, ISleeveModelMapper.class, IMechanicMapper.class })
public interface IGameMapper extends IGenericMapper<Game, GameRequest, GameResponse, GameFilter> {

	@Mapping(source = "image", target = "image.file")
	public Game toEntity(GameRequest request);

	@Mapping(source = "resquest.image", target = "image.file")
	public Game toUpdateEntity(GameRequest resquest, Long id);
	
}
