package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.AuthorFilter;
import br.com.byron.luderia.dto.request.AuthorRequest;
import br.com.byron.luderia.dto.response.AuthorResponse;
import br.com.byron.luderia.model.Author;

@Mapper(componentModel = "spring")
public interface IAuthorMapper extends IGenericMapper<Author, AuthorRequest, AuthorResponse, AuthorFilter>{

}
