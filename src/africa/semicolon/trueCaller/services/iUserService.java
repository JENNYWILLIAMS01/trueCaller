package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.trueCaller.dtos.Responses.RegisterUserResponse;

public interface iUserService {
    RegisterUserResponse register(RegisterUserRequest request);

    int getNumberOfUsers();

    String findEmail(String email);

    String updateEmail(String email);
}