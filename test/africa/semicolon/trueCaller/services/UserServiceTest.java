package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.Exceptions.UserExistsException;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.Requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private iUserService service;
    private ContactService contactService;
    private UserRepository userRepo;
     @BeforeEach
     void setUp() {
         contactService = new ContactService();
         userRepo = new UserRepositoryImpl();
         service = new UserService(userRepo, contactService);
     }

    @Test
    public void registerTest() {
        //given
        //there is a request from
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("oma@gmail.com");
        request.setFirstName("omotola");
        request.setLastName("williams");
        request.setPhoneNumber("09018272272");
        request.setUserName("posh");
        request.setPassword("password");
        //when
        service.register(request);
        //i try to register

        //assert
        //repository size is one
        assertEquals(1, service.getNumberOfUsers());
    }

    @Test
    public void duplicateEmailThrowsException() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("oma@gmail.com");
        request.setFirstName("omotola");
        request.setLastName("williams");
        request.setPhoneNumber("09018272272");
        request.setUserName("posh");
        request.setPassword("password");
        service.register(request);


        RegisterUserRequest request2 = new RegisterUserRequest();
        request2.setEmail("deborah@gmail.com");
        request2.setFirstName("deborah");
        request2.setLastName("jennifer");
        request2.setPhoneNumber("08070374568");
        request2.setUserName("debby");
        request2.setPassword("password2");
        service.register(request2);

        assertThrows(UserExistsException.class, () -> service.register(request));

        assertEquals(2, service.getNumberOfUsers());
        assertThrows(UserExistsException.class, () -> service.register(request2));
    }
    @Test
    public void addContactTest() {
        //given that i have a user
        //when i add contact
        //check that contacts size has increased
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("fashola@gmail.com");
        request.setFirstName("omotola");
        request.setLastName("williams");
        request.setPhoneNumber("09018272272");
        request.setUserName("posh");
        request.setPassword("password");
        service.register(request);

        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setUserEmail("fashola@gmail.com");
        addContactRequest.setFirstName("Abdur-Rahman");
        addContactRequest.setLastName("fashola");
        addContactRequest.setEmail("shafspecs@gmail.com");
        addContactRequest.setPhoneNumber("090807686544");
        service.addContact(addContactRequest);

       assertEquals(1, service.findContactsBelongingTo("fashola@gmail.com").size());





    }








}

//    @Test
//    public void findUserEmailTest() {
//        RegisterUserRequest request = new RegisterUserRequest();
//        request.setEmail("patience506@gmail.com");
//        request.setName("patience");
//        request.setPhoneNumber("08176543148");
//        request.setUserName("pachela");
//        request.setPassword("password");
//        service.register(request);
//
//
//        RegisterUserRequest request2 = new RegisterUserRequest();
//        request2.setEmail("busola347@gmail.com");
//        request2.setName("busola");
//        request2.setPhoneNumber("09034589768");
//        request2.setUserName("bukky");
//        request2.setPassword("password");
//        service.register(request2);
//
//        assertEquals(2, service.findEmail("email"));
//    }
//
//    @Test
//    public void updateEmailTest(){
//        RegisterUserRequest request = new RegisterUserRequest();
//        request.setEmail("patience506@gmail.com");
//        request.setName("patience");
//        request.setPhoneNumber("08176543148");
//        request.setUserName("pachela");
//        request.setPassword("password");
//        service.register(request);
//
//        RegisterUserRequest request2 = new RegisterUserRequest();
//        request2.setEmail("busola347@gmail.com");
//        request2.setName("busola");
//        request2.setPhoneNumber("09034589768");
//        request2.setUserName("bukky");
//        request2.setPassword("password");
//        service.register(request2);
//
//        assertEquals(2, service.updateEmail("email"));
//    }
//
//
//


