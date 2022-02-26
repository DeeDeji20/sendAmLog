package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    void delete(User user);
    User findBy(String email);
    List<User> findAll();
    int count();
}
