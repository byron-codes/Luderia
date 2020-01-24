package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.UserFilter;
import br.com.byron.luderia.dto.request.UserRequest;
import br.com.byron.luderia.dto.response.UserResponse;
import br.com.byron.luderia.model.User;

@Mapper(componentModel = "spring")
public interface IUserMapper extends IGenericMapper<User, UserRequest, UserResponse, UserFilter>{

}
