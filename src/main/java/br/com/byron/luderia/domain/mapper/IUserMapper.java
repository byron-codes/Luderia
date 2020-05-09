package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.UserFilter;
import br.com.byron.luderia.domain.request.UserRequest;
import br.com.byron.luderia.domain.request.UserUpdateRequest;
import br.com.byron.luderia.domain.response.UserResponse;
import br.com.byron.luderia.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper extends IGenericMapper<User, UserRequest, UserResponse, UserFilter> {

    public User toUpdateEntity(UserUpdateRequest resquest, Long id);

}
