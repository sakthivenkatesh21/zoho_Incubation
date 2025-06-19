package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.model.Card;
import zohoincubation.com.zoho.ecommerce.src.model.CardProduct;
import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class AddCard implements Operation {
    private Product product;

    AddCard(Product product) {
        this.product = product;
    }

    @Override
    public String getfunctionName() {
        return "Add Card";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {
        if(loggedInUser.getId() != 2) {
            System.out.println("You are not authorized to add products to the cart. Only buyers can add products to the cart.");
            return;
        }
        Card card = ((Client)loggedInUser).getcard(); 
        System.out.println("Enter a Quantity for the product " );
        int quantity = sc.nextInt();
        sc.nextLine();
        CardProduct cardProduct =  new CardProduct(card.getProduct().size()+1, product, quantity) ; 
        if(cardProduct.canAddToCard()){
            card.getProduct().add(cardProduct);
            product.setStock(product.getStock()-quantity); 
            System.out.println("Product added to the cart successfully: " + product.getProductName());       
        } else {
            System.out.println("Cannot add product to the cart. Please check the stock availability.");
        }
    }
    
}
