package zohoincubation.com.zoho.ecommerce.src.model;

import java.util.ArrayList;
import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.view.CheckOut;
import zohoincubation.com.zoho.ecommerce.src.view.Operation;
import zohoincubation.com.zoho.ecommerce.src.view.ViewCategory;
import zohoincubation.com.zoho.ecommerce.src.view.ViewProduct;

public class Client extends User {
    
    private Card card;
    private String address;
    private String paymentDetails;
    private List<Order> previousOrderProduct;
    
    
    public Client() {
        // this.operations = new Operation[]{
        //     new ViewCategory(),
        //     new ViewProduct(),
        //     new CheckOut(),
            
        // };
    }

    public Client(int id, String name,String phone, String email, String password, String gender, String address, String paymentDetails) {
        super(id, name, phone, email, password, gender);
        this.card = new Card();
        this.address = address;
        this.paymentDetails = paymentDetails;
        previousOrderProduct = new ArrayList<>();
        
    }
    private void list(){
        this.operations = new Operation[]{
            new ViewCategory(),
            new ViewProduct(),
            new CheckOut(),
            
        };
    }

    protected Operation[] getOperations() {
        if (operations == null) {
            list();
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
