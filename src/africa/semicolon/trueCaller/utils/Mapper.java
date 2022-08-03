package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.trueCaller.dtos.Responses.AllContactResponse;

public class Mapper {

    public static void map(RegisterUserRequest request, User userRepo) {
        userRepo.setPassword(request.getPassword());
        userRepo.setUsername(request.getUserName());
        userRepo.setEmail(request.getEmail());
        userRepo.setFirstName(request.getFirstName());
        userRepo.setLastName(request.getLastName());
        userRepo.setPhoneNumber(request.getPhoneNumber());
    }

    public static void map(AllContactResponse singleResponse, Contact contact) {
            singleResponse.setFirstName(contact.getFirstName());
            singleResponse.setLastName(contact.getLastName());
            singleResponse.setId(contact.getId() + "");
    }
}
