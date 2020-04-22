package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.SaleChangeFilter;
import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.dto.request.SaleChangeRequest;
import br.com.byron.luderia.dto.request.SaleRequest;
import br.com.byron.luderia.dto.response.SaleChangeResponse;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.model.SaleChange;
import br.com.byron.luderia.model.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = ISaleChangeItemMapper.class)
public interface ISaleChangeMapper extends IGenericMapper<SaleChange, SaleChangeRequest, SaleChangeResponse, SaleChangeFilter> {

    public SaleChange toEntity(SaleChangeRequest request);

}
