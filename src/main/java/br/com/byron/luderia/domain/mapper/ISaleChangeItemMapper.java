package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.SaleChangeItemFilter;
import br.com.byron.luderia.domain.request.SaleChangeItemRequest;
import br.com.byron.luderia.domain.response.SaleChangeItemResponse;
import br.com.byron.luderia.domain.model.SaleChangeItem;
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
