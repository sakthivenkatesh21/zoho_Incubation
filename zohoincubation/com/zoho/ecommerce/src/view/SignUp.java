package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.UserController;

public class SignUp {

    public void createUser(Scanner sc, Navigation navigation) {

        System.out.println("Enter a Name ");
        String name = sc.nextLine();
        System.out.println("Enter a Mobile Number");
        String phone = sc.nextLine();
        System.out.println("Enter the Email");
        String email = sc.nextLine();
        System.out.println("Enter a Password");
        String password = sc.nextLine();
        System.out.println("Enter a Gender");
        String gender = sc.nextLine();

        System.out.println("Are you Signing Up as Client or Seller?\n 1.Client\n 2.Seller");
        int userType = sc.nextInt();
        sc.nextLine();

        if (userType == 1) {
            System.out.println("Enter an Address");
            String address = sc.nextLine();
            UserController.createUser(name, phone, email, password, gender, address);
        } else if (userType == 2) {
            System.out.println("Enter a Company Name (If you are a Seller)");
            String company = sc.nextLine();
            System.out.println("Enter a Company Address (If you are a Seller)");
            String companyAddress = sc.nextLine();
            UserController.createUser(name, phone, email, password, gender,company, companyAddress);
        } else {
            System.out.println("Invalid User");
            return;
        }
    }
}
