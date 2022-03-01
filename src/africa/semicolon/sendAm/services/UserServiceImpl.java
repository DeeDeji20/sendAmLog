package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.data.repositories.UserRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse register(RegisterUserRequests requestForm) {
        User user =new User();
        user.setEmail(requestForm.getEmailAddress());
        user.setAddress(requestForm.getAddress());
        user.setPhoneNumber(requestForm.getPhoneNumber());
        user.setFullName(requestForm.getFirstName() + " " + requestForm.getLastName());
        userRepository.save(user);

        return null;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }
}
