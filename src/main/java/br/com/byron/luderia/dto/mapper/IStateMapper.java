package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.StateFilter;
import br.com.byron.luderia.dto.request.StateRequest;
import br.com.byron.luderia.dto.response.StateResponse;
import br.com.byron.luderia.model.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStateMapper extends IGenericMapper<State, StateRequest, StateResponse, StateFilter> {

}
