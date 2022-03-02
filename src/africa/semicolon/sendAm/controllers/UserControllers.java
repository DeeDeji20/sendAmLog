package africa.semicolon.sendAm.controllers;

import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.services.UserService;
import africa.semicolon.sendAm.services.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserControllers {
    private UserService userService = new UserServiceImpl();

    @PostMapping("/register")
    public RegisterUserResponse registerNewUser( @RequestBody RegisterUserRequests request) {
        return userService.register(request);
    }

    @GetMapping("/{email}")
    public FindUserResponse getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
