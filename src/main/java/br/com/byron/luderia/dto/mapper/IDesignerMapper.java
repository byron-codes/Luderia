package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.DesignerFilter;
import br.com.byron.luderia.dto.request.DesignerRequest;
import br.com.byron.luderia.dto.response.DesignerResponse;
import br.com.byron.luderia.model.Designer;

@Mapper(componentModel = "spring")
public interface IDesignerMapper extends IGenericMapper<Designer, DesignerRequest, DesignerResponse, DesignerFilter>{

}
