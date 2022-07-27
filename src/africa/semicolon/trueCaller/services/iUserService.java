package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dtos.Requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.trueCaller.dtos.Responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.Responses.RegisterUserResponse;

import java.util.List;

public interface iUserService {
    RegisterUserResponse register(RegisterUserRequest request);

    AddContactResponse addContact(AddContactRequest request);

    int getNumberOfUsers();

    List<Contact> findContactBelongingTo(String userEmail);
}

//    String findEmail(String email);
//
//    String updateEmail(String email);
//}