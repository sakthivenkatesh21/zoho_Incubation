package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.List;
import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.model.User;

public class LogIn {
    // private static DataManager dataManager  ;
    private static List<User> user  = DataManager.getDataManager().getUser();
    private static boolean isValidUser = false;
    private static User loggedUser = null;

    public static User logIn(String email ,String password ){
        for(User data : user){
            if(data.getEmail().equals(email) && data.getPassword().equals(password)){
                System.out.println("Welcome " + data.getName());
                isValidUser = true;
                loggedUser = data;
                return data;
            }
        }
    }

}
