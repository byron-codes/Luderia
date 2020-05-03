package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.SaleChangeFilter;
import br.com.byron.luderia.dto.request.SaleChangeRequest;
import br.com.byron.luderia.dto.response.SaleChangeResponse;
import br.com.byron.luderia.model.SaleChange;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ISaleChangeItemMapper.class)
public interface ISaleChangeMapper extends IGenericMapper<SaleChange, SaleChangeRequest, SaleChangeResponse, SaleChangeFilter> {

    public SaleChange toEntity(SaleChangeRequest request);

}
