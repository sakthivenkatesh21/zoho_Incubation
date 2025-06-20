package zohoincubation.com.zoho.ecommerce.src.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.view.Execute;
import zohoincubation.com.zoho.ecommerce.src.view.OrderHelper;
import zohoincubation.com.zoho.ecommerce.src.view.ProductHelper;
import zohoincubation.com.zoho.ecommerce.src.view.WishlistHandler;

public class Client extends User {
    
    private Card card;
    private String address;
    private String paymentDetails;
    private List<Order> previousOrderProduct;
    
    
    public Client() {}

    public Client(int id, String name,String phone, String email, String password, String gender, String address, String paymentDetails) {
        super(id, name, phone, email, password, gender);
        this.card = new Card();
        this.address = address;
        this.paymentDetails = paymentDetails;
        previousOrderProduct = new ArrayList<>();
        
    }
    private void list(Scanner sc , User loggedInUser){
        this.operations = new Execute[]{
            new ProductHelper(sc, loggedInUser),
            new WishlistHandler(sc,loggedInUser),
            new OrderHelper(sc, loggedInUser),
           
            
        };
    }

    protected Execute[] getOperations(Scanner sc, User loggedInUser) {
        if (operations == null) {
            list(sc, loggedInUser);
        }
        return operations;
    }

    public Card getcard() {
        return card;
    }

    public void setcard(Card card) {
        this.card = card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<Order> getPreviousOrderProduct() {
        return previousOrderProduct;
    }

    public void setPreviousOrderProduct(List<Order> previousOrderProduct) {
        this.previousOrderProduct = previousOrderProduct;
    }

    public int getRole(){
        return 1;
    }
    
    public String toString(){
        System.out.println("Client ID : " + getId());
        System.out.println("Client Name : " + getName());
        System.out.println("Client Phone : " + getPhone());
        System.out.println("Client Email : " + getEmail());
        System.out.println("Address : " + address);
        
        return "";
    }
}
