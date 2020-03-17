package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.AwardFilter;
import br.com.byron.luderia.dto.filter.CityFilter;
import br.com.byron.luderia.dto.request.AwardRequest;
import br.com.byron.luderia.dto.request.CityRequest;
import br.com.byron.luderia.dto.response.AwardResponse;
import br.com.byron.luderia.dto.response.CityResponse;
import br.com.byron.luderia.model.Award;
import br.com.byron.luderia.model.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICityMapper extends IGenericMapper<City, CityRequest, CityResponse, CityFilter> {

}
