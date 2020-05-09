package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.GameCategoryFilter;
import br.com.byron.luderia.domain.request.GameCategoryRequest;
import br.com.byron.luderia.domain.response.GameCategoryResponse;
import br.com.byron.luderia.domain.model.GameCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IGameCategoryMapper extends IGenericMapper<GameCategory, GameCategoryRequest, GameCategoryResponse, GameCategoryFilter>{

}
