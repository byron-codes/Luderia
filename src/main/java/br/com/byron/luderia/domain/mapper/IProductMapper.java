package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.ProductFilter;
import br.com.byron.luderia.domain.request.ProductRequest;
import br.com.byron.luderia.domain.response.ProductResponse;
import br.com.byron.luderia.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper extends IGenericMapper<Product, ProductRequest, ProductResponse, ProductFilter> {

}
