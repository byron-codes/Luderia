package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.CreditCardFilter;
import br.com.byron.luderia.domain.request.CreditCardRequest;
import br.com.byron.luderia.domain.request.IdRequest;
import br.com.byron.luderia.domain.response.CreditCardResponse;
import br.com.byron.luderia.domain.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICreditCardMapper extends IGenericMapper<CreditCard, CreditCardRequest, CreditCardResponse, CreditCardFilter>{

    @Mapping(source = "request.id", target = "id")
    public CreditCard toEntity(IdRequest request);

}
