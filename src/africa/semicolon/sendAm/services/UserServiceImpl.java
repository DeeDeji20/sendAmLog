package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.data.repositories.UserRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse register(RegisterUserRequests requestForm) {
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());

        if(emailExists(requestForm.getEmailAddress())) throw new RegisterFailureException("Email is not unique");

        User user =new User();
        user.setEmail(requestForm.getEmailAddress());
        user.setAddress(requestForm.getAddress());
        user.setPhoneNumber(requestForm.getPhoneNumber());
        user.setFullName(requestForm.getFirstName() + " " + requestForm.getLastName());
        User savedUser = userRepository.save(user);

        RegisterUserResponse response= new RegisterUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setFullName(savedUser.getFullName());
//        response.setEmail(savedUser.getEmail());
        return response;
    }

    private boolean emailExists(String emailAddress) {
        User user = userRepository.findBy(emailAddress);
        if(user == null) return false;
        return true;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public FindUserResponse findByEmail(String email) {
        User user = userRepository.findBy(email);
        // create response
        FindUserResponse response = new FindUserResponse();
        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());
        return null;
    }


}
