package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.Exceptions.UserExistsException;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import africa.semicolon.trueCaller.dtos.Responses.RegisterUserResponse;

public class UserService implements iUserService {
    private UserRepository userRepo = new UserRepositoryImpl();
    private User user = new User();
    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        // check if email exists and throw exception

        //create a new user
        //copy fields  from request to new user
        //save new user into repository
        User savedUser = userRepo.findByEmail(request.getEmail());

        if(savedUser != null) throw new UserExistsException(request.getEmail() + " already exists!");

        User user = new User();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUserName());
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPhoneNumber(request.getPhoneNumber());

        userRepo.save(user);

        return null;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepo.count();
    }

    @Override
    public String findEmail(String email) {
        if(user.getEmail() == email){
            user.setEmail(request.getEmail());
        }
        return ("");
    }

    @Override
    public String updateEmail(String email) {
        return ("");
    }
}
