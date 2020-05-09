package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.SaleItemFilter;
import br.com.byron.luderia.domain.request.SaleItemRequest;
import br.com.byron.luderia.domain.response.SaleItemResponse;
import br.com.byron.luderia.domain.model.SaleItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISaleItemMapper extends IGenericMapper<SaleItem, SaleItemRequest, SaleItemResponse, SaleItemFilter>{

	@Mapping(source = "id", target = "product.id")
	public SaleItem toEntity(SaleItemRequest request);

	@Mapping(source = "resquest.id", target = "product.id")
	public SaleItem toUpdateEntity(SaleItemRequest resquest, Long id);
	
}
