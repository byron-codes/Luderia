package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.ExpansionFilter;
import br.com.byron.luderia.domain.request.ExpansionRequest;
import br.com.byron.luderia.domain.response.ExpansionResponse;
import br.com.byron.luderia.domain.model.Expansion;
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
