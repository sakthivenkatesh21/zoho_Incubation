package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.InputMismatchException;
import java.util.Scanner;
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
            System.out.println("""
                    ╔═══════════════════════════════════════════════════╗
                   ||           ✏️ UPDATE USER INFORMATION MENU         ||
                    ╚═══════════════════════════════════════════════════╝
                    1️⃣  🧑  Update Name
                    2️⃣  📱  Update Phone Number
                    3️⃣  📧  Update Email
                    4️⃣  🔒  Update Password
                    5️⃣  🚻  Update Gender""");
            if (loggedInUser.getRole() == 1) {
                System.out.println("6️⃣  🏠  Update Address (Client)");
            } else if (loggedInUser.getRole() == 2) {
                System.out.println("""
                        6️⃣  🏢  Update Company Name (Seller)
                        7️⃣  📍  Update Company Address (Seller)""");
            }
            System.out.println("""
                    0️⃣  ❌  Exit Update Menu
                    ════════════════════════════════════════════════════
                    """);
            System.out.print("👉 Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        loggedInUser.setName(check.name("🧑 Enter new Name: "));
                        System.out.println("✅ Name updated successfully." + loggedInUser.getName());
                    }
                    case 2 -> {
                        loggedInUser.setPhone(isPhoneExists(check.phone("📱 Enter new phone number: "), check));
                        System.out.println("✅ Phone number updated successfully." + loggedInUser.getPhone());
                    }
                    case 3 -> {
                        loggedInUser.setEmail(isEmailExists(check.email("📧 Enter new email: "), check));
                        System.out.println("✅ Email updated successfully." + loggedInUser.getEmail());
                    }
                    case 4 -> {
                        loggedInUser.setPassword(check.password("🔒 Enter new password: "));
                        System.out.println("✅ Password updated successfully.");
                    }
                    case 5 -> {
                        loggedInUser.setGender(check.gender("🚻 Enter new gender: "));
                        System.out.println("✅ Gender updated successfully." + loggedInUser.getGender());
                    }
                    case 6 -> {
                        if (loggedInUser.getRole() == 1) {
                            ((Client) loggedInUser).setAddress(check.address("🏠 Enter new address: "));
                            System.out.println("✅ Address updated successfully." + ((Client) loggedInUser).getAddress());
                        } else if (loggedInUser.getRole() == 2) {
                            ((Seller) loggedInUser).setCompany(check.name("🏢 Enter new company name: "));
                            System.out.println("✅ Company name updated successfully." + ((Seller) loggedInUser).getCompany());
                        }
                    }
                    case 7 -> {
                        if (loggedInUser.getRole() == 2) {
                            ((Seller) loggedInUser).setCompanyAddress(check.address("📍 Enter new company address: "));
                            System.out.println("✅ Company address updated successfully." + ((Seller) loggedInUser).getCompanyAddress());
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
        }
    }

    public static String[] getDetails(Scanner sc) {
        ValidData check = new ValidData(sc);
        String name = check.name("🧑 Enter your Name :");
        String phone = isPhoneExists(check.phone("📱 Enter a valid phone number: "), check);
        String email = isEmailExists(check.email("📧 Enter a valid email address: "), check);
        String password = check.password("🔒 Type your Password:");
        String gender = check.gender("🚻 Enter your Gender:");

        System.out.println("👥 Are you Signing Up as Client or Seller?\n 1️⃣ Client\n 2️⃣ Seller (Enter @ Number)");
        int userType = sc.nextInt();
        sc.nextLine();

        switch (userType) {
            case 1 -> {
                String address = check.address("🏠 Enter Address:");
                return new String[]{name, phone, email, password, gender, address};
            }
            case 2 -> {
                String company = check.name("🏢 Enter a Company Name :");
                String companyAddress = check.address("📍 Enter a Company Address :");
                return new String[]{name, phone, email, password, gender, company, companyAddress};
            }
            default -> {
                System.out.println("❌ Invalid User Type");
                return null;
            }
        }
    }

    private static String isEmailExists(String email, ValidData check) {
        while (UserController.isMailExists(email)) {
            System.out.println("❌ Email already exists. Please try again with a different email.");
            email = check.email("📧 Enter a valid email address: ");
        }
        return email;
    }

    private static String isPhoneExists(String phone, ValidData check) {
        while (UserController.isPhoneExists(phone)) {
            System.out.println("❌ Phone number already exists. Please try again with a different number.");
            phone = check.phone("📱 Enter a valid phone number: ");
        }
        return phone;
    }
}
