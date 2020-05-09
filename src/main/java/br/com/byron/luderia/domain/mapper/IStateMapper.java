package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.StateFilter;
import br.com.byron.luderia.domain.request.StateRequest;
import br.com.byron.luderia.domain.response.StateResponse;
import br.com.byron.luderia.domain.model.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStateMapper extends IGenericMapper<State, StateRequest, StateResponse, StateFilter> {

}
