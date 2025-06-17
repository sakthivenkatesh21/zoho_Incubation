package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

public class Navigation {
    private static  Scanner sc;

    public Navigation(){
        sc = new Scanner(System.in);
    }
    
    public static void menu(){
        System.out.println("Welcome to E - Commerce ");
        while(true){
            System.out.println("1.SigUP\n2.SignIN\n3.Exit");
            System.out.println("Enter a Choice ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    new SignUp().createUser(sc);
                    break;
                case 2:
                    new LogIn().logIn(sc);
                    break;
                case 3:
                    
                    break;
                default:
                System.out.println("Invalid Choice");
                    break;
            }

        }
    }
}
