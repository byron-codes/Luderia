package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.UserFilter;
import br.com.byron.luderia.dto.request.UserRequest;
import br.com.byron.luderia.dto.request.UserUpdateRequest;
import br.com.byron.luderia.dto.response.UserResponse;
import br.com.byron.luderia.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper extends IGenericMapper<User, UserRequest, UserResponse, UserFilter> {

    public User toUpdateEntity(UserUpdateRequest resquest, Long id);

}
