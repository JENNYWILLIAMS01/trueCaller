package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.Exceptions.UserExistsException;
import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.Requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.trueCaller.dtos.Responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.Responses.RegisterUserResponse;
import africa.semicolon.trueCaller.utils.Mapper;

import java.util.List;

public class UserService implements iUserService {
    private UserRepository userRepo;
    private final iContactService contactService;

    public UserService(UserRepository userRepository, ContactService contactService) {
        this.userRepo = userRepository;
        this.contactService = contactService;
    }

    public UserService() {
        this.userRepo = new UserRepositoryImpl();
        this.contactService = new ContactService();
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        validate(request.getEmail());
        User user = new User();
        Mapper.map(request, user);
        userRepo.save(user);
        return null;
        // check if email exists and throw exception

        //create a new user
        //copy fields  from request to new user
        //save new user into repository
    }

    private void validate (String email) {
        User savedUser = userRepo.findByEmail(email);
        if (savedUser != null) throw new UserExistsException(email + " already exists!");


    }

    @Override
    public AddContactResponse addContact(AddContactRequest addContactResponse) {
        //create a contact
        //save contact to repository
        //find user by email
        //add contact to user contact lists
        //save user
        Contact contact = new Contact();
        contact.setEmail(addContactResponse.getEmail());
        contact.setLastName(addContactResponse.getLastName());
        contact.setFirstName(addContactResponse.getLastName());
        contact.setPhoneNumber(addContactResponse.getPhoneNumber());

        Contact savedContact = contactService.addNewContact(contact);

        User user = userRepo.findByEmail(addContactResponse.getUserEmail());

        user.getContacts().add(savedContact);

        userRepo.save(user);

        return null;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepo.count();
    }

    @Override
    public List<Contact> findContactBelongingTo(String userEmail) {
        User user = userRepo.findByEmail(userEmail);
        return user.getContacts();
    }
}

//    @Override
//    public String findEmail(String email) {
//        if(user.getEmail() == email){
//            user.setEmail(request.getEmail());
//        }
//        return ("");
//    }
//
//    @Override
//    public String updateEmail(String email) {
//        return ("");
//    }
//}
