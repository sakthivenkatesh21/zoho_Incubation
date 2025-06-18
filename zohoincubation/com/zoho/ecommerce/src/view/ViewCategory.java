package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.CategoryController;
import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class ViewCategory implements Operation {

    @Override
    public String getfunctionName() {
        return "View Category";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {

       if(CategoryController.isCategoryEmpty()){
            System.out.println("No categories available. Please add a category first.");
            return;
        }

        //while(true){
            System.out.println("Available Categories:");
            for(int i = 0; i < CategoryController.getCategories().size(); i++) {
                System.out.println((i + 1) + ". " +CategoryController.getCategories().get(i).getName());
            }
       // }
    
    }
    public static Category  getCategory(Scanner sc) {
        if(CategoryController.isCategoryEmpty()){
            return null;
        }
        System.out.println("Available Categories:");
        for(int i = 0; i < CategoryController.getCategories().size(); i++) {
            System.out.println((i + 1) + ". " + CategoryController.getCategories().get(i).getName());
        }
        int categoryIndex;
            do{
                System.out.println("Select a category by entering the corresponding number:");
                categoryIndex = sc.nextInt()-1; 
                sc.nextLine();  
            }while( categoryIndex < 0 || categoryIndex >= CategoryController.getCategories().size());
        // System.out.println("Selected Category: " + CategoryController.getCategories().get(categoryIndex));

        return CategoryController.getCategories().get(categoryIndex);
    }
}
