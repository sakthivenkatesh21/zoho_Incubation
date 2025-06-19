package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.CategoryController;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class AddCategory implements Operation {
   
        @Override
        public   String getfunctionName () {
            return "Add Category";
        }

        @Override
        public void  operation(Scanner sc, User loggedInUser) {
            System.out.println("Enter the Category Name");
            String categoryName = sc.nextLine();
            System.out.println("Enter the Category Description");
            String categoryDescription = sc.nextLine();

            if(CategoryController.createCategory(categoryName, categoryDescription)!=null)
                System.out.println("Category Created Successfully");
            else 
                System.out.println("Category with name '" + categoryName + "' already exists.");
        }
}
