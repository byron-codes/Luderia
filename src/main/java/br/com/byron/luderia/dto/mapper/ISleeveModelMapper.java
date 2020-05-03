package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.SleeveModelFilter;
import br.com.byron.luderia.dto.request.SleeveModelRequest;
import br.com.byron.luderia.dto.response.SleeveModelResponse;
import br.com.byron.luderia.model.SleeveModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISleeveModelMapper extends IGenericMapper<SleeveModel, SleeveModelRequest, SleeveModelResponse, SleeveModelFilter>{

}
