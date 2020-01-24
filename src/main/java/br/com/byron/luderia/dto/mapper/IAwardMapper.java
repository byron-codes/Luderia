package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.AwardFilter;
import br.com.byron.luderia.dto.request.AwardRequest;
import br.com.byron.luderia.dto.response.AwardResponse;
import br.com.byron.luderia.model.Award;

@Mapper(componentModel = "spring")
public interface IAwardMapper extends IGenericMapper<Award, AwardRequest, AwardResponse, AwardFilter>{

}
