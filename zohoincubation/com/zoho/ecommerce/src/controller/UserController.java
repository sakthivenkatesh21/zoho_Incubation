package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class UserController {
    private static int idGenerator;
    private static List<User> userList = DataManager.getDataManager().getUser();

    public static void createUser(String name,String phone, String email,String password,String gender,String address,String paymentDetails){
        // Client s = new Client();
        // Seller c = new Seller();
        User user = new Client(++idGenerator,name,phone,email,password,gender,address,paymentDetails);
        userList.add(user);
    }
    public static void createUser(String name,String phone, String email,String password,String gender,int soldItem,int profit,String company,String companyAddress){
        User user = new Seller(++idGenerator,name,phone,email,password,gender,soldItem,profit,company,companyAddress);
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
