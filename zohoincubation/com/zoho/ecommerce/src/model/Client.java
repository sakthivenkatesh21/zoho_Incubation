package zohoincubation.com.zoho.ecommerce.src.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    
    private Card card;
    private String address;
    private String paymentDetails;
    private List<Order> previousOrderProduct;
    
    
    public Client() {
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

    
    
}
