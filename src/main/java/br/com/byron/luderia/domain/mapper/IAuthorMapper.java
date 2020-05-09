package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.AuthorFilter;
import br.com.byron.luderia.domain.request.AuthorRequest;
import br.com.byron.luderia.domain.response.AuthorResponse;
import br.com.byron.luderia.domain.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAuthorMapper extends IGenericMapper<Author, AuthorRequest, AuthorResponse, AuthorFilter>{

}
