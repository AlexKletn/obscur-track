package space.obscur.obscurtrack.adapter.in.users.http.requests;

import org.mapstruct.Mapper;
import space.obscur.obscurtrack.application.domain.users.domain.User;

@Mapper(componentModel = "spring")
public interface CreateUserRequestMapper {
    CreateUserRequest toRequest(User user);
    User toDomainModel(CreateUserRequest createUserRequest);
}
