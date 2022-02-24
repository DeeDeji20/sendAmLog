package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    UserRepositoryImpl userRepository;
    @BeforeEach
    void setup(){
        userRepository = new UserRepositoryImpl();
    }
    @Test
    void test_that_user_can_be_saved_in(){
        User user = new User("deolaoladeji@gmail.com","Dee Deji", "07031054664", "Kubwa");
        userRepository.save(user);
//        User userDetails = userRepository.getUser();
        assertEquals(1, userRepository.count());

    }

    @Test
    void test_that_user_can_be_deleted_from_list(){
        User firstUser = new User("deolaoladeji@gmail.com","Dee Deji", "07031054664", "Kubwa");
        User secondUser = new User();
        User thirdUser = new User();
        userRepository.save(firstUser);
        userRepository.save(secondUser);
        userRepository.save(thirdUser);

        userRepository.delete(secondUser);
        assertEquals(2, userRepository.count());
        assertNull(userRepository.findBy(secondUser.getEmail()));
    }

    @Test
    void test_that_user_can_be_found_by_email(){
        User firstUser = new User("deolaoladeji@gmail.com","Dee Deji", "07031054664", "Kubwa");
        User secondUser = new User();
        User thirdUser = new User();
        userRepository.save(firstUser);
        userRepository.save(secondUser);
        userRepository.save(thirdUser);

        User foundUser = userRepository.findBy("deolaoladeji@gmail.com");
        assertEquals(firstUser, foundUser);
    }

    @Test
    void test_that_all_users_can_be_found(){
        User firstUser = new User("deolaoladeji@gmail.com","Dee Deji", "07031054664", "Kubwa");
        User secondUser = new User();
        User thirdUser = new User();
        userRepository.save(firstUser);
        userRepository.save(secondUser);
        userRepository.save(thirdUser);

        List<User> users =userRepository.findAll();
        assertEquals(3, users.size());
    }
}