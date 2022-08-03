package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.Exceptions.UserExistsException;
import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dtos.Requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.trueCaller.dtos.Responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.Responses.AllContactResponse;
import africa.semicolon.trueCaller.dtos.Responses.RegisterUserResponse;
import africa.semicolon.trueCaller.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService = new UserService();
    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request) {
        try {
            RegisterUserResponse serviceResponse = userService.register(request);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        }catch (UserExistsException err){
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("/user")
    public AddContactResponse addContact(@RequestBody AddContactRequest addContactRequest) {
        return userService.addContact(addContactRequest);
    }

    @GetMapping("/user/{email}")
        public List <AllContactResponse> findContactsBelongingTo(@PathVariable("emails") String email) {
            return userService.findContactsBelongingTo(email);
        }
    }
