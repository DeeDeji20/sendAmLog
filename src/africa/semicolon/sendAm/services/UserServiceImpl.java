package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.data.repositories.UserRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse register(RegisterUserRequests requestForm) {
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());

        if(emailExists(requestForm.getEmailAddress())) throw new RegisterFailureException("Email is not unique");

        System.out.println("Nothing was thrown");
        User user =new User();
        user.setEmail(requestForm.getEmailAddress());
        user.setAddress(requestForm.getAddress());
        user.setPhoneNumber(requestForm.getPhoneNumber());
        user.setFullName(requestForm.getFirstName() + " " + requestForm.getLastName());
        userRepository.save(user);

        return null;
    }

    private boolean emailExists(String emailAddress) {
        User user = userRepository.findBy(emailAddress);
        System.out.println(userRepository.findAll());
        if(user == null) return false;
        return true;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }
}
