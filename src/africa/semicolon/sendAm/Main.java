package africa.semicolon.sendAm;

import africa.semicolon.sendAm.controllers.UserControllers;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequests;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static UserControllers userController = new UserControllers();
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        //load options
//        loadOptions();
        // if option is register
            //load form
//          print ouput
//          load option
        // if option is search by email
            // ask for email
//            show
//            load option
    }

    private static void loadOptions() {
        String options = """
                -> A for Register
                -> B for find by email              
                """;
//        display(options);
        String input =  collectInput(options);
        switch (input.toLowerCase()){
            case "a" ->loadRegisterForm();
            case "b" -> askUserForEmail();
            default -> {
                display("Get sense");
                loadOptions();
            }
        }
    }

    private static void askUserForEmail() {
        String userEmail = collectInput("Enter the email you want to search");
        FindUserResponse response = userController.getUserByEmail(userEmail);
    }

    private static void loadRegisterForm() {
        RegisterUserRequests form = new RegisterUserRequests();
        form.setEmailAddress(collectInput("Enter your emial address"));
        form.setAddress(collectInput("Enter your address"));
        form.setFirstName(collectInput("Enter your firstname"));
        form.setLastName(collectInput("Enter your lastName"));
        form.setPhoneNumber(collectInput("Enter your phone number"));
        RegisterUserResponse response = userController.registerNewUser(form);
        display(response.toString());
        loadOptions();
    }

    private static String collectInput(String message) {
        Scanner scanner = new Scanner(System.in);
        display(message);
        return scanner.nextLine();
    }

    private static void display(String massage) {
        System.out.println(massage);
    }
}
