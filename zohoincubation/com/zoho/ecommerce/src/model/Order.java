package zohoincubation.com.zoho.ecommerce.src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private Client client;
    private String address;
    private LocalDateTime orderTime;
    private OrderStatus status;
    private double total;
    private String payment;
    // private List<Seller> seller;
    private List<CardProduct> product; 


    public Order(){
        // this.seller = new ArrayList<>();
        this.product = new ArrayList<>();   
    }
    public Order(int id, Client client,String address, OrderStatus status, double total,
            String payment,/*List<Seller> seller,*/  List<CardProduct> product) {
        this.id = id;
        this.client = client;
        this.address = address;
        this.orderTime = LocalDateTime.now();
        this.status = status;
        this.total = total;
        this.payment = payment;
        // this.seller = seller;
        this.product = product;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // public List<Seller>  getSeller() {
    //     return seller;
    // }

    // public void setSeller(List<Seller> seller) {
    //     this.seller = seller;
    // }

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

    // public double claculateOrderTotal(){
    //     double total  =0;
    //     for(Product prod : product)
    //         total +=prod.getStock()*prod.getPrice();
    //     return total;    
    // }
    private String  print (){
        StringBuilder sb = new StringBuilder();
        for (CardProduct prod : product) {
            sb.append(String.format("🛍️ %s (Qty: %d, Price: $%.2f)\n", prod.getProductName(), prod.getQuantity(), prod.getPrice()));
        }
        return sb.toString();
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------\n");
        sb.append("🧾 Order Summary\n");
        sb.append("--------------------------------------------------\n");
        sb.append(String.format("📦 Order ID      : %s\n", id));
        sb.append(String.format("👤 Client        : %s\n", client.getName()));
        sb.append(String.format("📍 Address       : %s\n", address));
        sb.append(String.format("🕒 Order Time    : %s %s\n", getFormattedDate(), getFormattedTime()));
        sb.append(String.format("📌 Status        : %s\n", status));
        sb.append(String.format("💰 Total Amount  : $%.2f\n", total));
        sb.append(String.format("💳 Payment Method: %s\n", payment));
        sb.append(String.format("🛒 Products      : %s\n", print()));
        sb.append("--------------------------------------------------\n");
        return sb.toString();
    }

    
    


}
