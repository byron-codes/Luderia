package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.AddressFilter;
import br.com.byron.luderia.domain.request.AddressRequest;
import br.com.byron.luderia.domain.response.AddressResponse;
import br.com.byron.luderia.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ICityMapper.class, IStateMapper.class})
public interface IAddressMapper extends IGenericMapper<Address, AddressRequest, AddressResponse, AddressFilter> {

    @Mapping(source = "cityId", target = "city.id")
    public Address toEntity(AddressRequest request);

    @Mapping(source = "resquest.cityId", target = "city.id")
    public Address toUpdateEntity(AddressRequest resquest, Long id);

    @Mapping(source = "city.state", target = "state")
    public AddressResponse toResponse(Address entity);

}
