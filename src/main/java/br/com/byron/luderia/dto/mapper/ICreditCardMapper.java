package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.CreditCardFilter;
import br.com.byron.luderia.dto.request.CreditCardRequest;
import br.com.byron.luderia.dto.response.CreditCardResponse;
import br.com.byron.luderia.model.CreditCard;

@Mapper(componentModel = "spring")
public interface ICreditCardMapper extends IGenericMapper<CreditCard, CreditCardRequest, CreditCardResponse, CreditCardFilter>{

}
