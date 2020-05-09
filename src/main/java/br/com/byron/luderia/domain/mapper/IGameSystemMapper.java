package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.GameSystemFilter;
import br.com.byron.luderia.domain.request.GameSystemRequest;
import br.com.byron.luderia.domain.response.GameSystemResponse;
import br.com.byron.luderia.domain.model.GameSystem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IGameSystemMapper extends IGenericMapper<GameSystem, GameSystemRequest, GameSystemResponse, GameSystemFilter>{

}
