package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.CityFilter;
import br.com.byron.luderia.domain.request.CityRequest;
import br.com.byron.luderia.domain.response.CityResponse;
import br.com.byron.luderia.domain.model.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICityMapper extends IGenericMapper<City, CityRequest, CityResponse, CityFilter> {

}
