package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

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

    public WishlistHandler(Product product) {
        this.product = product;
    }

    @Override
    public String getfunctionName() {
        return "WishList";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {
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
        if (loggedInUser.getId() != 2) {
            System.out.println("You are not authorized to add products to the cart. Only buyers can add products to the cart.");
            return;
        }
        Card card = ((Client) loggedInUser).getcard();
        System.out.println("Enter a Quantity for the product ");
        int quantity = sc.nextInt();
        sc.nextLine();
        CardProduct cardProduct = new CardProduct(card.getProduct().size() + 1, product, quantity);
        if (cardProduct.canAddToCard()) {
            card.getProduct().add(cardProduct);
            product.setStock(product.getStock() - quantity);
            System.out.println("Product added to the cart successfully: " + product.getProductName());
        } else {
            System.out.println("Cannot add product to the cart. Please check the stock availability.");
        }
    }

    public void view() {
        if(loggedInUser.getId()==1) {
            card  = ((Client) loggedInUser).getcard();

            for(int i=0; i<card.getProduct().size(); i++){ 
                System.out.println("Product " + (i+1) + ":"+ card.getProduct().get(i).getProductName()+" Price: " + card.getProduct().get(i).getPrice());
                System.out.println("\t Quantity: " + card.getProduct().get(i).getQuantity()+"    OrderStatus: " + card.getProduct().get(i).getProducStatus());
                System.out.println();
                          
                System.out.println("-----------------------------");
            }
        }
    }

    public void update() {
        CardProduct cardProduct = checkCardProduct();
        if (cardProduct == null) return;    
        Product product = cardProduct;
        System.out.println("Enter the new quantity for the product:");
        int oldQuantity = cardProduct.getQuantity();
        int newQuantity = sc.nextInt();
        cardProduct.setQuantity(newQuantity);
        sc.nextLine();
        if (cardProduct.canAddToCard()) {
            product.setStock(product.getStock() - newQuantity);
            cardProduct.setQuantity(cardProduct.getQuantity() + oldQuantity);
            System.out.println("Product added to the cart successfully: " + product.getProductName());
        } else {
            cardProduct.setQuantity(oldQuantity); 
            System.out.println("Cannot add product to the cart. Please check the stock availability.");
        }
    }

    public void delete() {
        while(true) {
            CardProduct cardProduct = checkCardProduct();
            if(cardProduct == null)  return;         
            card.getProduct().remove(cardProduct);
            System.out.println("Product " + cardProduct.getProductName() + " has been removed from your cart.");
            cardProduct.reStock();
          }
    }

    private CardProduct  checkCardProduct(){
        view();
        System.out.println("Enter the  ID to remove from the cart \n Or Enter '-1' to Exit ");
        int indexId = sc.nextInt() - 1;
        if(indexId == -1 && indexId >=card.getProduct().size()) {
            System.out.println("You have chosen to proceed with Exit.");
            return  null;
         }
         return card.getProduct().get(indexId); 
    }
}
