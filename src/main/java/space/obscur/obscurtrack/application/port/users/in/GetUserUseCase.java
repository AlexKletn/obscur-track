package space.obscur.obscurtrack.application.port.users.in;

import space.obscur.obscurtrack.application.domain.users.domain.User;
import space.obscur.obscurtrack.common.itemsList.ItemsList;

public interface GetUserUseCase {
    User get(Integer userId);
    ItemsList<User> getList();
}
