package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dtos.Requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.trueCaller.dtos.Responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.Responses.RegisterUserResponse;
import africa.semicolon.trueCaller.services.UserService;

import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        return userService.register(request);
    }

    public AddContactResponse addContact(AddContactRequest addContactRequest) {
        return userService.addContact(addContactRequest);
    }

    public List<Contact> findContactsBelongingTo(String email){
        return userService.findContactBelongingTo(email);
    }
}
