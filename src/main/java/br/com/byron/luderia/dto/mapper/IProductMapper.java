package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.ProductFilter;
import br.com.byron.luderia.dto.request.ProductRequest;
import br.com.byron.luderia.dto.response.ProductResponse;
import br.com.byron.luderia.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper extends IGenericMapper<Product, ProductRequest, ProductResponse, ProductFilter> {

}
