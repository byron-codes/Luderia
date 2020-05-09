package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.GameFilter;
import br.com.byron.luderia.domain.request.GameRequest;
import br.com.byron.luderia.domain.response.GameResponse;
import br.com.byron.luderia.domain.model.Game;
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
