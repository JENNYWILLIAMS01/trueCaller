package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.controllers.UserController;
import africa.semicolon.trueCaller.dtos.Requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
@SpringBootApplication

public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private static UserController userController = new UserController();

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        displayMainMenu();
    }


    private static void displayMainMenu ()
    //prompt user with menu
    //if user selects a,b,c,d direct them
    {
        String mainMenuPrompt = """
                    Welcome To Omaposh's True Caller App
                    1 -> Create an Account
                    2 -> Add contact to a user
                    3 -> Find contact belong to user
                    """;
        System.out.println(mainMenuPrompt);
        String userInput = keyboardInput.nextLine();
        switch (userInput.charAt(0)) {
            case '1' -> createAnAccount();
            case '2' -> addAccountToUser();
            case '3' -> findContactBelongingTo();


        }
    }

    private static void findContactBelongingTo() {
        var contacts = userController.findContactsBelongingTo(input("Enter your email"));
        for(var contact: contacts){
            System.out.println(contact.toString());
        }

        contacts.forEach(contact -> System.out.println(contact.toString()));
        displayMainMenu();
    }

    private static void addAccountToUser() {
        AddContactRequest contactRequest = new AddContactRequest();

        contactRequest.setEmail(input("Enter contact email:"));
        contactRequest.setUserEmail(input("Enter your email:"));
        contactRequest.setFirstName(input("Enter contact's firstName:"));
        contactRequest.setLastName(input("Enter contact's lastName:"));
        contactRequest.setPhoneNumber(input("Enter contact's phoneNumber:"));
        userController.addContact(contactRequest);
        displayMainMenu();

    }


    private static void createAnAccount () {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName(input("Enter contact's firstName:"));
        request.setLastName(input("Enter contact's lastName:"));
        request.setPhoneNumber(input("Enter phoneNumber:"));
        request.setEmail(input("Enter contact email:"));
        request.setPassword(input("Enter password:"));

        userController.registerUser(request);
        displayMainMenu();
    }

    public static String input (String prompt){
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }

}
