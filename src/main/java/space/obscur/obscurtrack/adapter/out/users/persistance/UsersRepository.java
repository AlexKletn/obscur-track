package space.obscur.obscurtrack.adapter.out.users.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Integer> {
}
