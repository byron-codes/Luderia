package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.AwardFilter;
import br.com.byron.luderia.domain.request.AwardRequest;
import br.com.byron.luderia.domain.response.AwardResponse;
import br.com.byron.luderia.domain.model.Award;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAwardMapper extends IGenericMapper<Award, AwardRequest, AwardResponse, AwardFilter>{

}
