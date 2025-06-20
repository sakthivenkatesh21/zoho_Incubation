package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

public class Navigation {
    private static Scanner sc;

    public Navigation() {
        sc = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("Welcome to E - Commerce");
        while (true) {
            System.out.println("1. Sign Up\n2. Sign In\n3. Exit");
            System.out.println("Enter a Choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    new SignUp().createUser(sc, this);
                    break;
                case 2:
                    new LogIn().logIn(sc, this);
                    break;
                case 3:
                    exit(sc);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    private void exit(Scanner sc) {
        System.out.println("Thank you for using E - Commerce");
        sc.close();
        System.exit(0);
    }
}
