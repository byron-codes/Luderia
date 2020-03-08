package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.AccessoriesFilter;
import br.com.byron.luderia.dto.request.AccessoriesRequest;
import br.com.byron.luderia.dto.response.AccessoriesResponse;
import br.com.byron.luderia.model.Accessories;

@Mapper(componentModel = "spring")
public interface IAccessoriesMapper extends IGenericMapper<Accessories, AccessoriesRequest, AccessoriesResponse, AccessoriesFilter> {

}
