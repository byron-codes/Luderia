package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.DesignerFilter;
import br.com.byron.luderia.domain.request.DesignerRequest;
import br.com.byron.luderia.domain.response.DesignerResponse;
import br.com.byron.luderia.domain.model.Designer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDesignerMapper extends IGenericMapper<Designer, DesignerRequest, DesignerResponse, DesignerFilter>{

}
