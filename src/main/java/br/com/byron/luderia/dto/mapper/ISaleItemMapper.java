package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.SaleItemFilter;
import br.com.byron.luderia.dto.request.SaleItemRequest;
import br.com.byron.luderia.dto.response.SaleItemResponse;
import br.com.byron.luderia.model.SaleItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISaleItemMapper extends IGenericMapper<SaleItem, SaleItemRequest, SaleItemResponse, SaleItemFilter>{

	@Mapping(source = "id", target = "product.id")
	public SaleItem toEntity(SaleItemRequest request);

	@Mapping(source = "resquest.id", target = "product.id")
	public SaleItem toUpdateEntity(SaleItemRequest resquest, Long id);
	
}
