package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class UserController {
    private static int idGenerator;
    private static List<User> userList = DataManager.getDataManager().getUser();

    public static void createUser(String name, String phone, String email, String password, String gender, String address, String paymentDetails) {
        User user = new Client(++idGenerator, name, phone, email, password, gender, address, paymentDetails);
        userList.add(user);
    }

    public static void createUser(String name, String phone, String email, String password, String gender, int soldItem, int profit, String company, String companyAddress) {
        User user = new Seller(++idGenerator, name, phone, email, password, gender, soldItem, profit, company, companyAddress);
        userList.add(user);
    }
}
