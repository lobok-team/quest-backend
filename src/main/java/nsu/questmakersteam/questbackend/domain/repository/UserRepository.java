package nsu.questmakersteam.questbackend.domain.repository;

import nsu.questmakersteam.questbackend.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLoginIgnoreCase(String login);
}
