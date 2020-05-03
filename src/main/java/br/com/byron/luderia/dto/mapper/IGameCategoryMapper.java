package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.GameCategoryFilter;
import br.com.byron.luderia.dto.request.GameCategoryRequest;
import br.com.byron.luderia.dto.response.GameCategoryResponse;
import br.com.byron.luderia.model.GameCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IGameCategoryMapper extends IGenericMapper<GameCategory, GameCategoryRequest, GameCategoryResponse, GameCategoryFilter>{

}
