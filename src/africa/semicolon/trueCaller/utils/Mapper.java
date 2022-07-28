package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;

public class Mapper {

    public static void map(RegisterUserRequest request, User userRepo) {
        userRepo.setPassword(request.getPassword());
        userRepo.setUsername(request.getUserName());
        userRepo.setEmail(request.getEmail());
        userRepo.setName(request.getName());
        userRepo.setPhoneNumber(request.getPhoneNumber());
    }
}
