package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.SaleChangeItemFilter;
import br.com.byron.luderia.dto.request.SaleChangeItemRequest;
import br.com.byron.luderia.dto.response.SaleChangeItemResponse;
import br.com.byron.luderia.model.SaleChangeItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = IProductMapper.class)
public interface ISaleChangeItemMapper extends IGenericMapper<SaleChangeItem, SaleChangeItemRequest, SaleChangeItemResponse, SaleChangeItemFilter> {

    @Mappings({
            @Mapping(source = "id", target = "product.id"),
            @Mapping(target = "id", ignore = true)
    })
    public SaleChangeItem toEntity(SaleChangeItemRequest request);

}
