package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.ProductController;

import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.User;

import zohoincubation.com.zoho.ecommerce.src.model.Client;



public class AddProduct implements Operation {

    @Override
    public String getfunctionName() {
        return "Add Product";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {
        if((loggedInUser instanceof Client)) {
            System.out.println("You are not authorized to add a product. Only sellers can add products.");
            return;
        }
        Category category = ViewCategory.getCategory(sc);
        if (category == null) {
            System.out.println("No category selected. Please select a category first.");
            return;
        }
        System.out.println("Enter the Product Name");
        String productName = sc.nextLine();
        System.out.println("Enter the Product Description");
        String productDescription = sc.nextLine();
        System.out.println("Enter the Product Price");
        double productPrice = sc.nextDouble();
        System.out.println("Enter the Product Stock");
        int productStock = sc.nextInt();
        sc.nextLine(); 
        Product product =ProductController.createProduct(productName, productDescription, productPrice, productStock,category, loggedInUser);
        if(product == null) {
            System.out.println("Product with the same name already exists.");
        } else {
            System.out.println("Product added successfully: " + product.getProductName());
        }

    }

    
}
