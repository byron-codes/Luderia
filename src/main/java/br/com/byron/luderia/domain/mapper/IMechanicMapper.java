package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.MechanicFilter;
import br.com.byron.luderia.domain.request.MechanicRequest;
import br.com.byron.luderia.domain.response.MechanicResponse;
import br.com.byron.luderia.domain.model.Mechanic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMechanicMapper extends IGenericMapper<Mechanic, MechanicRequest, MechanicResponse, MechanicFilter>{

}
