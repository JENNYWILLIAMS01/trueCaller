package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.controllers.UserController;
import africa.semicolon.trueCaller.dtos.Requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.Requests.RegisterUserRequest;

import java.util.Scanner;


public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private static UserController userController = new UserController();

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu ()
    //prompt user with menu
    //if user selects a,b,c,d direct them
    {
        String mainMenuPrompt = """
                    Welcome to True caller
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
        contactRequest.setName(input("Enter contact's Name:"));
        contactRequest.setPhoneNumber(input("Enter contact's phoneNumber:"));
        userController.addContact(contactRequest);
        displayMainMenu();

    }


    private static void createAnAccount () {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setName(input("Enter name:"));
        request.setPhoneNumber(input("Enter phone:"));
        request.setEmail(input("Enter email:"));
        request.setPassword(input("Enter password:"));

        userController.registerUser(request);
        displayMainMenu();
    }

    public static String input (String prompt){
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }
}