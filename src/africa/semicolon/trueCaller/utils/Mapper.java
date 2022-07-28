package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;

public class Mapper {

    public static void map(RegisterUserRequest request, User userRepo) {
        userRepo.setPassword(request.getPassword());
        userRepo.setUsername(request.getUserName());
        userRepo.setEmail(request.getEmail());
        userRepo.setFirstName(request.getFirstName());
        userRepo.setLastName(request.getLastName());
        userRepo.setPhoneNumber(request.getPhoneNumber());
    }
}
