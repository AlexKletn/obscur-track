package space.obscur.obscurtrack.adapter.out.users.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import space.obscur.obscurtrack.application.domain.users.domain.User;
import space.obscur.obscurtrack.application.port.users.out.UsersStorage;
import space.obscur.obscurtrack.common.itemsList.ItemsList;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersPersistenceAdapter implements UsersStorage {
    private final UsersRepository usersRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public boolean push(User user) {
        usersRepository.save(userEntityMapper.toEntity(user));
        return false;
    }
    @Override
    public boolean push(Integer id, User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);

        userEntity.setId(id);

        usersRepository.save(userEntity);

        return false;
    }

    @Override
    public ItemsList<User> find() {
        Integer total = (int) usersRepository.count();
        List<User> users = usersRepository.findAll()
                .stream()
                .map(userEntityMapper::toDomainModel)
                .toList();

        ItemsList<User> usersList = new ItemsList<User>();
        usersList.setItems(users);
        usersList.setTotal(total);

        return usersList;
    }

    @Override
    public Optional<User> findOne(Integer id) {
        return usersRepository.findById(id).map(userEntityMapper::toDomainModel);
    }
}

