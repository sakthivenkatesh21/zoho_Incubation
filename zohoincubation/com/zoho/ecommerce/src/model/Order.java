package zohoincubation.com.zoho.ecommerce.src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private Seller seller;
    private Client client;
    private LocalDateTime orderTime;
    private OrderStatus status;
    private double total;
    private String payment;
    private List<CardProduct> product; 


    public Order(){
        product  = new ArrayList<>();
    }


    public Order(int id, Seller seller, Client client, LocalDateTime orderTime, OrderStatus status, double total,
            String payment, List<CardProduct> product) {
        this.id = id;
        this.seller = seller;
        this.client = client;
        this.orderTime = orderTime;
        this.status = status;
        this.total = total;
        this.payment = payment;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<CardProduct> getProduct() {
        return product;
    }
    public String getFormattedDate(){
        return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(orderTime);
    }

    public String getFormattedTime(){
        return DateTimeFormatter.ofPattern("hh:mm").format(orderTime);
    }

    public void setProduct(List<CardProduct> product) {
        this.product = product;
    }

    public double claculateOrderTotal(){
        double total  =0;
        for(Product prod : product)
            total +=prod.getStock()*prod.getPrice();
        return total;    
    }
    
    


}
