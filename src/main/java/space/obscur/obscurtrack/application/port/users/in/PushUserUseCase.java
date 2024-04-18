package space.obscur.obscurtrack.application.port.users.in;

import space.obscur.obscurtrack.application.domain.users.domain.User;

public interface PushUserUseCase {
    boolean push(User user);
    boolean push(Integer id, User user);
}
