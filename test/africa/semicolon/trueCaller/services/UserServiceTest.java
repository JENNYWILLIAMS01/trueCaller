package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.Exceptions.UserExistsException;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.trueCaller.dtos.Responses.RegisterUserResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    iUserService service = new UserService();


    @Test
    public void registerTest() {
        //given
        //there is a request from
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("oma@gmail.com");
        request.setName("oma");
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
        request.setName("oma");
        request.setPhoneNumber("09018272272");
        request.setUserName("posh");
        request.setPassword("password");
        service.register(request);


        RegisterUserRequest request2 = new RegisterUserRequest();
        request2.setEmail("deborah@gmail.com");
        request2.setName("deborah");
        request2.setPhoneNumber("08070374568");
        request2.setUserName("debby");
        request2.setPassword("password2");
        service.register(request2);

        assertThrows(UserExistsException.class, () -> service.register(request));

        assertEquals(2, service.getNumberOfUsers());
        assertThrows(UserExistsException.class, () -> service.register(request2));
    }

    @Test
    public void findUserEmailTest() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("patience506@gmail.com");
        request.setName("patience");
        request.setPhoneNumber("08176543148");
        request.setUserName("pachela");
        request.setPassword("password");
        service.register(request);


        RegisterUserRequest request2 = new RegisterUserRequest();
        request2.setEmail("busola347@gmail.com");
        request2.setName("busola");
        request2.setPhoneNumber("09034589768");
        request2.setUserName("bukky");
        request2.setPassword("password");
        service.register(request2);

        assertEquals(2, service.findEmail("email"));
    }

    @Test
    public void updateEmailTest(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("patience506@gmail.com");
        request.setName("patience");
        request.setPhoneNumber("08176543148");
        request.setUserName("pachela");
        request.setPassword("password");
        service.register(request);

        RegisterUserRequest request2 = new RegisterUserRequest();
        request2.setEmail("busola347@gmail.com");
        request2.setName("busola");
        request2.setPhoneNumber("09034589768");
        request2.setUserName("bukky");
        request2.setPassword("password");
        service.register(request2);

        assertEquals(2, service.updateEmail("email"));
    }
}


