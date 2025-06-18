package zohoincubation.com.zoho.ecommerce.src.model;

import java.util.ArrayList;
import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.view.Operation;
import zohoincubation.com.zoho.ecommerce.src.view.ViewCategory;
import zohoincubation.com.zoho.ecommerce.src.view.ViewProduct;

public class Client extends User {
    
    private Card card;
    private String address;
    private String paymentDetails;
    private List<Order> previousOrderProduct;
    
    
    public Client() {
        this.operations = new Operation[]{
            new ViewCategory(),
            new ViewProduct(),
            
            
        };
        previousOrderProduct = new ArrayList<>();
       
    }

    public Client(Card card, String address, String paymentDetails, List<Order> previousOrderProduct) {
        this.card = card;
        this.address = address;
        this.paymentDetails = paymentDetails;
        this.previousOrderProduct = previousOrderProduct;
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
    
}
