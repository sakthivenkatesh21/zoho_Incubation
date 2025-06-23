package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.validation.Validator;
import zohoincubation.com.zoho.ecommerce.src.controller.UserController;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Editable;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Execute;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Viewable;
import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class UserHelper implements Execute, Editable, Viewable {
    private final User loggedInUser;
    private final Scanner sc;

    public UserHelper(User loggedInUser, Scanner sc) {
        this.loggedInUser = loggedInUser;
        this.sc = sc;
    }

    @Override
    public String getfunctionName() {
        return "User Management";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {
        while (true) {
            System.out.println("====================================");
            System.out.println("         🛠️ User Management Menu       ");
            System.out.println("====================================");
            System.out.println("1️⃣ View Info");
            System.out.println("2️⃣ Update Info");
            System.out.println("0️⃣ Exit");
            System.out.println("====================================");
            System.out.print("👉 Enter your choice: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> view();
                    case 2 -> update();
                    case 0 -> {
                        System.out.println("👋 Exiting User Management.");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("❌ An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    @Override
    public void view() {
        String role = loggedInUser.getRole() == 1 ? "👤 Client" : "🏢 Seller";
        System.out.println("""
                ╔═══════════════════════════════════════════════════╗
               ||                📋 USER INFORMATION                ||  
                ╚═══════════════════════════════════════════════════╝
                """);

        System.out.printf("🔑 Role              : %-30s%n", role);
        System.out.printf("🧑 Name              : %-30s%n", loggedInUser.getName());
        System.out.printf("📧 Email             : %-30s%n", loggedInUser.getEmail());
        System.out.printf("🆔 User ID           : %-30s%n", loggedInUser.getId());

        if (loggedInUser.getRole() == 2) {
            Seller seller = (Seller) loggedInUser;
            System.out.printf("💰 Profit Earned     : ₹%-29.2f%n", seller.getProfit());
            System.out.printf("📦 Products Sold     : %-30d%n", seller.getSoldItem());
        }

        System.out.println("═════════════════════════════════════════════════════════");
    }

    @Override
    public void update() {
        ValidData check = new ValidData(sc);
        while (true) {
            System.out.println("✏️ Updating User Information...");
            System.out.println("1️⃣ Update Name");
            System.out.println("2.📱 Update Phone Number");
            System.out.println("3. Update Email");
            System.out.println("4. Update Password");
            System.out.println("5. Update Gender");
            if (loggedInUser.getRole() == 1) {
                System.out.println("6. Update Address (Client)");
            } else if (loggedInUser.getRole() == 2) {
                System.out.println("6. Update Company Info (Seller)");
                System.out.println("7. Update Company Address (Seller)");
            }
            System.out.println("0️⃣ Exit Update Menu");
            System.out.print("👉 Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> loggedInUser.setName(check.name());
                    case 2 -> loggedInUser.setPhone(isPhoneExists(check.phone())) ;   
                    case 3 -> loggedInUser.setEmail(isEmailExists(check.email()));                       
                    case 4 -> loggedInUser.setPassword(check.password());
                    case 5 -> loggedInUser.setGender(check.gender());
                    case 6 -> {
                        if (loggedInUser.getRole() == 1) {
                            ((Client) loggedInUser).setAddress(check.address());
                        } else if (loggedInUser.getRole() == 2) {
                            ((Seller) loggedInUser).setCompany(check.name());
                        }
                    }
                    case 7 -> {
                        if (loggedInUser.getRole() == 2) {
                            ((Seller) loggedInUser).setCompanyAddress(check.address());
                        } else {
                            System.out.println("❌ Invalid choice for Client, no updates made.");
                        }
                    }
                    case 0 -> {
                        System.out.println("👋 Exiting Update Menu.");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice, no updates made.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a valid number.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("❌ An unexpected error occurred: " + e.getMessage());
            }
            System.out.println("✅ User information updated successfully.");
            System.out.println("📋 Updated User Information: \t " + loggedInUser);
        }
    }

    public static String[] getDetails(Scanner sc) {
        ValidData check = new ValidData(sc);
        String name = check.name();     
        String phone = isPhoneExists(check.phone());
        
        String email = isEmailExists(check.email());
        
        String password = check.password();
        String gender = check.gender();

        System.out.println("👥 Are you Signing Up as Client or Seller?\n 1️⃣ Client\n 2️⃣ Seller (Enter @ Number)");
        int userType = sc.nextInt();
        sc.nextLine();

        switch (userType) {
            case 1 -> {
                String address = check.address();
                return new String[]{name,phone, email, password, gender, address};
            }
            case 2 -> {
                System.out.println("🏢 Enter a Company Name :");
                String company = check.name();
                System.out.println("📍 Enter a Company Address :");
                String companyAddress = check.address();
                return new String[]{name, phone,email, password, gender, company, companyAddress};
            }
            default -> {
                System.out.println("❌ Invalid User Type");
                return null;
            }
        }
    }
    private String isEmailExists(String email,Validator check) {
        while(UserController.isMailExists(email)){
            System.out.println("❌ Email already exists. Please try again with a different email.");
            email = check.email();
        }
        return email;
    }
    private String isPhoneExists(String phone,Validator check) {
        while(UserController.isPhoneExists(phone)){
            System.out.println("❌ Phone number already exists. Please try again with a different number.");
            phone = check.phone();
        }
        return phone;
    }
}
