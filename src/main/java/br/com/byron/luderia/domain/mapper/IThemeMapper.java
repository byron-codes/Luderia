package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.ThemeFilter;
import br.com.byron.luderia.domain.request.ThemeRequest;
import br.com.byron.luderia.domain.response.ThemeResponse;
import br.com.byron.luderia.domain.model.Theme;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IThemeMapper extends IGenericMapper<Theme, ThemeRequest, ThemeResponse, ThemeFilter>{

}