package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequests requestForm);

    UserRepository getRepository();

    FindUserResponse findByEmail(String email);
}
