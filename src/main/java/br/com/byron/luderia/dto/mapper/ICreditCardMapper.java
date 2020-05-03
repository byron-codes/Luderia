package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.CreditCardFilter;
import br.com.byron.luderia.dto.request.CreditCardRequest;
import br.com.byron.luderia.dto.request.IdRequest;
import br.com.byron.luderia.dto.response.CreditCardResponse;
import br.com.byron.luderia.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICreditCardMapper extends IGenericMapper<CreditCard, CreditCardRequest, CreditCardResponse, CreditCardFilter>{

    @Mapping(source = "request.id", target = "id")
    public CreditCard toEntity(IdRequest request);

}
