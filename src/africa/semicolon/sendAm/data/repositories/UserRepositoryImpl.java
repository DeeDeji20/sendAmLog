package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> usersRepo = new ArrayList<>();


    @Override
    public User save(User user) {
        usersRepo.add(user);
        return user;
    }

    @Override
    public void delete(User user) {
        usersRepo.remove(user);
    }

    @Override
    public User findBy(String email) {
        for (User user : usersRepo) {
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return usersRepo;
    }

    @Override
    public int count() {
        return usersRepo.size();
    }

}
