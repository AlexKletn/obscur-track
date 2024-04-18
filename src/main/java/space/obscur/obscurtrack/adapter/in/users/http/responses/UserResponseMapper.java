package space.obscur.obscurtrack.adapter.in.users.http.responses;

import org.mapstruct.Mapper;
import space.obscur.obscurtrack.application.domain.users.domain.User;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponse toResponse(User user);
    User toDomainModel(UserResponse userResponse);
}
