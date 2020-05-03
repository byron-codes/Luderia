package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.AccessoriesFilter;
import br.com.byron.luderia.dto.request.AccessoriesRequest;
import br.com.byron.luderia.dto.response.AccessoriesResponse;
import br.com.byron.luderia.model.Accessories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IAccessoriesMapper extends IGenericMapper<Accessories, AccessoriesRequest, AccessoriesResponse, AccessoriesFilter> {

    @Mapping(source = "image", target = "image.file")
    public Accessories toEntity(AccessoriesRequest request);

    @Mapping(source = "resquest.image", target = "image.file")
    public Accessories toUpdateEntity(AccessoriesRequest resquest, Long id);

}
