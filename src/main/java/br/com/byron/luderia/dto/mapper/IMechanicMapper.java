package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.MechanicFilter;
import br.com.byron.luderia.dto.request.MechanicRequest;
import br.com.byron.luderia.dto.response.MechanicResponse;
import br.com.byron.luderia.model.Mechanic;

@Mapper(componentModel = "spring")
public interface IMechanicMapper extends IGenericMapper<Mechanic, MechanicRequest, MechanicResponse, MechanicFilter>{

}
