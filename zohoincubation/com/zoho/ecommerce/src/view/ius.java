package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.interfaceController.Execute;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class ius implements Execute {

        public String getfunctionName(){
            return "User Management";
        }
    
        public void operation(Scanner sc, User loggedInUser) {
            System.out.println("1.Add User\n2.View User\n3.Update User\n4.Delete User\n5.Exit\nEnter a choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("Exiting User Management.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    
    
        public void add(){}
    
        public  void view(){}
    
        public void  update(){}
    
        public void delete(){}
    
    
    
}
