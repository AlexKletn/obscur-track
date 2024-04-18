package space.obscur.obscurtrack.application.domain.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.obscur.obscurtrack.application.domain.users.domain.User;
import space.obscur.obscurtrack.application.port.users.in.GetUserUseCase;
import space.obscur.obscurtrack.application.port.users.in.PushUserUseCase;
import space.obscur.obscurtrack.application.port.users.out.UsersStorage;
import space.obscur.obscurtrack.common.itemsList.ItemsList;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService implements GetUserUseCase, PushUserUseCase {
    private final UsersStorage storage;

    @Override
    public User get(Integer userId) {
        Optional<User> user = storage.findOne(userId);

        if (user.isEmpty()) {
            throw new RuntimeException();
        }

        return user.get();
    }

    @Override
    public ItemsList<User> getList() {
        return storage.find();
    }

    @Override
    public boolean push(User user) {
        return storage.push(user);
    }
    @Override
    public boolean push(Integer id, User user) {
        return storage.push(user);
    }
}
