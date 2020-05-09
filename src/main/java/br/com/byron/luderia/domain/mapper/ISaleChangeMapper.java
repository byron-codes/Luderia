package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.SaleChangeFilter;
import br.com.byron.luderia.domain.request.SaleChangeRequest;
import br.com.byron.luderia.domain.response.SaleChangeResponse;
import br.com.byron.luderia.domain.model.SaleChange;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ISaleChangeItemMapper.class)
public interface ISaleChangeMapper extends IGenericMapper<SaleChange, SaleChangeRequest, SaleChangeResponse, SaleChangeFilter> {

    public SaleChange toEntity(SaleChangeRequest request);

}
