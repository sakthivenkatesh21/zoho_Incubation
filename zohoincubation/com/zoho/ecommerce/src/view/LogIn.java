package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.SignIn;

import zohoincubation.com.zoho.ecommerce.src.model.User;

public class LogIn {
    private User logInUser;

    public void logIn(Scanner sc, Navigation navigation) {

        System.out.println("Enter a Email");
        String email = sc.nextLine();
        System.out.println("Enter a Password");
        String password = sc.nextLine();
        logInUser = SignIn.validateLogIn(email, password);

        if(logInUser != null){
            System.out.println("Welcome " + logInUser.getName() + " to the E-Commerce Application");
           if (logInUser.getRole() == 1) {
               System.out.println("Login as Client");
               
           } else if (logInUser.getRole() == 2) {
               System.out.println("Login as Seller");
           } else {
               System.out.println("Invalid Role");
               return;
           }                 
           logInUser.showMenu(sc,logInUser);  
        }
        else{
            System.out.println("Invalid Email or Password");
            System.out.println("Please try again");
            return;
        }
    } 
    
}
