package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.LoginFilter;
import br.com.byron.luderia.dto.request.LoginRequest;
import br.com.byron.luderia.dto.request.UserPasswordRequest;
import br.com.byron.luderia.dto.request.UserUpdateRequest;
import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.UserFilter;
import br.com.byron.luderia.dto.request.UserRequest;
import br.com.byron.luderia.dto.response.UserResponse;
import br.com.byron.luderia.model.User;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserMapper extends IGenericMapper<User, UserRequest, UserResponse, UserFilter> {

    @Mapping(source = "login", target = "nickname")
    public LoginFilter fromLogin(LoginRequest request);

    public User toUpdateEntity(UserUpdateRequest resquest, Long id);

}
