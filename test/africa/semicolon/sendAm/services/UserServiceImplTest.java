package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserServiceImpl userService;
    @BeforeEach
    void setUp(){
        userService = new UserServiceImpl();
    }
    @Test
    void after_register_repository_has_one_element() {}{
        //given
        RegisterUserRequests registerForm = new RegisterUserRequests();
        registerForm.setFirstName("Lota");
        registerForm.setLastName("Senior");
        registerForm.setEmailAddress("Lota@gail.com");
        registerForm.setAddress("Code Cold Hell");
        registerForm.setPhoneNumber("2MillionDolars");

        //when
        userService.register(registerForm);

        //assert
        assertEquals(1, userService.getRepository().count());
    }
}