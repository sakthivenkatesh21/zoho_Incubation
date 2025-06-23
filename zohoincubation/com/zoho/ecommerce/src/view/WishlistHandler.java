package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.List;
import java.util.Scanner;
import zohoincubation.com.zoho.ecommerce.src.controller.ProductController;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Editable;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Execute;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Viewable;
import zohoincubation.com.zoho.ecommerce.src.model.Card;
import zohoincubation.com.zoho.ecommerce.src.model.CardProduct;
import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class WishlistHandler implements Execute, Editable, Viewable {
    private Scanner sc;
    private User loggedInUser;
    private Product product;
    private Card card;

    public WishlistHandler(Scanner sc, User loggedInUser) {
        this.sc = sc;
        this.loggedInUser = loggedInUser;
    }

    public WishlistHandler(Product product, Scanner sc, User loggedInUser) {
        this.product = product;
        this.sc = sc;
        this.loggedInUser = loggedInUser;
    }

    @Override
    public String getfunctionName() {
        return "WishList";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {
        // card = ((Client) loggedInUser).getcard();
        System.out.println("1.Add to WishList\n2.View WishList\n3.Update WishList\n4.Delete from WishList\n5.Exit\nEnter a choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                new ProductHelper(sc, loggedInUser).view();
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
                System.out.println("Exiting Wish List Management.");
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    public void add() {

        if (loggedInUser.getRole() == 2) {
            System.out.println("You are not authorized to add products to the cart. Only buyers can add products to the cart.");
            return;
        }
        card = ((Client) loggedInUser).getcard();
        System.out.println("Enter a Quantity for the product ");
        int quantity = sc.nextInt();
        sc.nextLine();
        if(ProductController.isProductExistCard(card.getProduct(),product.getId())) {
            System.out.println("Product already exists in the cart. Please update the quantity instead.");
            return;
        }
        CardProduct cardProduct = new CardProduct(card.getProduct().size() + 1, product, quantity);
        if (cardProduct.canAddToCard() && quantity<=10 && quantity >0) {
            card.getProduct().add(cardProduct);
            // product.setStock(product.getStock() - quantity);
            System.out.println("Product added to the cart successfully: " + product.getProductName());
            System.out.println("Updated Quantity :" + cardProduct.getQuantity());
        } else {
            System.out.println("Cannot add product to the cart. Please check the stock availability.");
        }
    }

    public void view() {
        if(loggedInUser.getRole()==1) {
            card  = ((Client) loggedInUser).getcard();
            if(card.getProduct().isEmpty()) {
                System.out.println("Your WishList is empty.");
                return;
            }
            for(int i=0; i<card.getProduct().size(); i++){ 
                System.out.println("Product " + (i+1) + ":"+ card.getProduct().get(i).getProductName()+" Price: " + (card.getProduct().get(i).getQuantity()*card.getProduct().get(i).getPrice()));
                System.out.println("\t Quantity: " + card.getProduct().get(i).getQuantity()+"    OrderStatus: " + card.getProduct().get(i).getProducStatus());
                System.out.println();
                          
                System.out.println("-----------------------------");
            }
        }
    }

    public void update() {
        card = ((Client) loggedInUser).getcard();
        if(card.getProduct().isEmpty()) {
            System.out.println("Your Wish List is empty. Please add products to the Wish List first.");
            return;
        }
        CardProduct cardProduct = checkCardProduct();
        if (cardProduct == null) return;    
        // Product product = cardProduct;
        System.out.println("Enter the new quantity for the product:");
        int oldQuantity = cardProduct.getQuantity();
        int newQuantity = sc.nextInt();
        cardProduct.setQuantity(newQuantity);
        sc.nextLine();
        if (cardProduct.canAddToCard() && newQuantity >0) {
            if(newQuantity > 10) {
                System.out.println("You cannot add more than 10 items to the cart.");
                newQuantity = 10; 
                cardProduct.setQuantity(newQuantity); 
            }

            // cardProduct.setQuantity(newQuantity);
            // product.setStock(product.getStock() - newQuantity);
            // cardProduct.setQuantity(cardProduct.getQuantity() + oldQuantity);
            System.out.println("Product Quantity added to the cart successfully: " + cardProduct.getProductName()+"Updaed Quantity :"+newQuantity);
        } else {
            cardProduct.setQuantity(oldQuantity); 
            System.out.println("Cannot add product to the cart. Please check the stock availability.");
        }
    }

    // private void updateQuantity(CardProduct cardProduct){
        
    // }

    public void delete() {
        if(card.getProduct().isEmpty()) {
            System.out.println("Your Wish List is empty. Please add products to the Wish List first.");
            return;
        }
        while(true) {
            CardProduct cardProduct = checkCardProduct();
            if(cardProduct == null)  return;         
            card.getProduct().remove(cardProduct);
            System.out.println("Product " + cardProduct.getProductName() + " has been removed from your cart.");
            // cardProduct.reStock();
          }
    }

   public void  checkQuantityExist(List<CardProduct> cardProduct){
        for(CardProduct obj : cardProduct){
            if(!obj.reStock()){
                System.out.println(obj.getProductName()+" Quantity Available :"+obj.getStock()+" Your Choosen Quantity is :"+obj.getQuantity());
                if(obj.getStock()>0){
                    obj.setQuantity(obj.getStock());
                    obj.reStock();
                    System.out.println("Available Stock  "+obj.getQuantity() +" Updated to "+obj.getProductName());
                }
                else{
                    System.out.println("The Product "+obj.getProductName()+" reached Out Of Stock ");
                    System.out.println("Its Removed From Card ");
                    card.getProduct().remove(cardProduct);
                }      
            }
        }     
    }

    private CardProduct  checkCardProduct(){
        view();
        System.out.println("Enter the  ID to remove from the cart \n Or Enter '-1' to Exit ");
        int indexId = sc.nextInt() ;
        if(indexId == -1){
             System.out.println("You have chosen to proceed with Exit.");
            return  null;
        }
        else if( indexId >=card.getProduct().size() || indexId<=0) {
            System.out.println("Invalid Card ID.");
            return  null;
         }
         return card.getProduct().get(indexId-1); 
    }
}
