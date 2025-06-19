package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.List;
import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.ProductController;

import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class ViewProduct implements Operation {
    
    public String getfunctionName() {
        return "View Product";
    }
    
    public void operation(Scanner sc, User loggedInUser) {
        Category  category = ViewCategory.getCategory(sc);
        if(category == null || category.getProduct().isEmpty()) {
            System.out.println("No product is Available ");
            return;
        }
      
        // System.out.println("1.View Products)");
        // System.out.println("2.Back(Exit)\n Enter a choice"); 
        // int choice = sc.nextInt();
        // sc.nextLine();
        while(true){
            System.out.println("1.View Products");
            System.out.println("2.Add to Cart");
            System.out.println("3.Back(Exit)\n Enter a choice"); 
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: showCategoryProducts(category);  
                    break;
                case 2: addToCard(category, sc, loggedInUser);
                    break;
                case 3:
                    System.out.println("Exiting to previous menu.");
                    return;
                default:
                    System.out.println("invalid choice. Please try again.");
                    break;
            }
        }

    }
            
            
    private void addToCard(Category category, Scanner sc, User loggedInUser) {
        if(loggedInUser.getId() != 2) {
            System.out.println("You are not authorized to add products to the cart. Only buyers can add products to the cart.");
            return;
        }
        showCategoryProducts(category);
        System.out.println("Enter the Product ID to add to cart or 0 to exit");
        int productId = sc.nextInt();
        sc.nextLine();
        
        while(productId != 0){ 
            if(productId < 0){
                System.out.println("Invalid Product ID. Please try again.");
            } else {
                Product product = ProductController.isProductExist(productId);
                if(product != null && category.getProduct().contains(product)) {
                    AddCard addCard = new AddCard(product);
                    addCard.operation(sc, loggedInUser);
                } else {
                    System.out.println("Product not found in the selected category.");
                }
            }
            showCategoryProducts(category);
            System.out.println("Enter the Product ID to add to cart or 0 to exit");
            productId = sc.nextInt();
            sc.nextLine();
        }
    }
    private void showCategoryProducts(Category category){
        System.out.println("Products in Category: " + category.getName()+"\n");
        for(Product product : category.getProduct()) {
            System.out.println(product);
        }     
    }
  
}

