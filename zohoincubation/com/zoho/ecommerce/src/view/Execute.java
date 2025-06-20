package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.model.User;

public interface Execute {
    String getfunctionName();
    void operation(Scanner sc,User loggedInUser);
}


