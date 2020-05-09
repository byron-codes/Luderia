package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.AccessoriesFilter;
import br.com.byron.luderia.domain.request.AccessoriesRequest;
import br.com.byron.luderia.domain.response.AccessoriesResponse;
import br.com.byron.luderia.domain.model.Accessories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IAccessoriesMapper extends IGenericMapper<Accessories, AccessoriesRequest, AccessoriesResponse, AccessoriesFilter> {

    @Mapping(source = "image", target = "image.file")
    public Accessories toEntity(AccessoriesRequest request);

    @Mapping(source = "resquest.image", target = "image.file")
    public Accessories toUpdateEntity(AccessoriesRequest resquest, Long id);

}
