package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.SleeveModelFilter;
import br.com.byron.luderia.domain.request.SleeveModelRequest;
import br.com.byron.luderia.domain.response.SleeveModelResponse;
import br.com.byron.luderia.domain.model.SleeveModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISleeveModelMapper extends IGenericMapper<SleeveModel, SleeveModelRequest, SleeveModelResponse, SleeveModelFilter>{

}
