package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.ThemeFilter;
import br.com.byron.luderia.dto.request.ThemeRequest;
import br.com.byron.luderia.dto.response.ThemeResponse;
import br.com.byron.luderia.model.Theme;

@Mapper(componentModel = "spring")
public interface IThemeMapper extends IGenericMapper<Theme, ThemeRequest, ThemeResponse, ThemeFilter>{

}