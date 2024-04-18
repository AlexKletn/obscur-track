package space.obscur.obscurtrack.adapter.out.users.persistance;

import org.mapstruct.Mapper;
import space.obscur.obscurtrack.application.domain.users.domain.User;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    User toDomainModel(UserEntity entity);
    UserEntity toEntity(User domainModel);
}
