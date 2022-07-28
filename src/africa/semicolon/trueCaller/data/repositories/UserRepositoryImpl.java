package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private List<User> users = new ArrayList<>();
    private int counter;
    @Override
    public int count() {
        return users.size();
    }

    @Override
    public User save(User user) {
        User foundUser = findById(user.getId());
        if (foundUser != null){
            user.setFirstName(foundUser.getFirstName());
            user.setLastName(foundUser.getLastName());
            user.setUsername(foundUser.getUsername());
            user.setPassword(foundUser.getPassword());
            user.setEmail(foundUser.getEmail());
            user.setContacts(foundUser.getContacts());
        } else {
            counter++;
            user.setId(counter);
            users.add(user);
        }
        return user;
    }
    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
    @Override
    public void delete(int id) {
        User foundUser = findById(id);
        users.remove(foundUser);
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User searchUser(String userName) {
        User foundUser = null;
        for (User thisUser : users){
            if (thisUser.getUsername().equalsIgnoreCase(userName)){
                foundUser = thisUser;
            }
        }
        return foundUser;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users){
            if(user.getEmail().equals(email))
                return user;
        }

        return null;
    }
}


