package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.GameSystemFilter;
import br.com.byron.luderia.dto.request.GameSystemRequest;
import br.com.byron.luderia.dto.response.GameSystemResponse;
import br.com.byron.luderia.model.GameSystem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IGameSystemMapper extends IGenericMapper<GameSystem, GameSystemRequest, GameSystemResponse, GameSystemFilter>{

}
