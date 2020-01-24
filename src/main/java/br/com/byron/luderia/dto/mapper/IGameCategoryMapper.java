package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.GameCategoryFilter;
import br.com.byron.luderia.dto.request.GameCategoryRequest;
import br.com.byron.luderia.dto.response.GameCategoryResponse;
import br.com.byron.luderia.model.GameCategory;

@Mapper(componentModel = "spring")
public interface IGameCategoryMapper extends IGenericMapper<GameCategory, GameCategoryRequest, GameCategoryResponse, GameCategoryFilter>{

}
