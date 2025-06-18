package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class UserController {
    private static int idGenerator;
    private static User user;
    private static List<User> userList = DataManager.getDataManager().getUser();

    public static void createUser(String name,String phone, String email,String password,String gender,String address,String paymentDetails){
        user = new Client();
        user.setId(++idGenerator);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        ((Client)user).setAddress(address);
        ((Client)user).setPaymentDetails(paymentDetails);
        userList.add(user);

    }
    public static void createUser(String name,String phone, String email,String password,String gender){
        user = new Seller();
        user.setId(++idGenerator);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        userList.add(user);
    }
    // private static int idGenerator(){
    //     Random rand = new Random();
    //     int id; 
    //     do{
    //         id = rand.nextInt(1000,9999);
    //     }while(!uniqueId(id));
    //     return id; 
    // }
    // private static boolean uniqueId(int id){
    //     if(userList.isEmpty()){
    //         return true;
    //     }
    //     for(User obj : userList){
    //         if(obj.getId() == id){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
