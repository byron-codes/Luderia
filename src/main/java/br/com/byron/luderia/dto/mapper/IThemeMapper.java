package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.ThemeFilter;
import br.com.byron.luderia.dto.request.ThemeRequest;
import br.com.byron.luderia.dto.response.ThemeResponse;
import br.com.byron.luderia.model.Theme;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IThemeMapper extends IGenericMapper<Theme, ThemeRequest, ThemeResponse, ThemeFilter>{

}