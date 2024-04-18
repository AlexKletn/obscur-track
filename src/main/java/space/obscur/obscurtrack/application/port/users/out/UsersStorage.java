package space.obscur.obscurtrack.application.port.users.out;

import space.obscur.obscurtrack.application.domain.users.domain.User;
import space.obscur.obscurtrack.common.port.out.ExternalStorage;

public interface UsersStorage extends ExternalStorage<User, Integer> {
}
