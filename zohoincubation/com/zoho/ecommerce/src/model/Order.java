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
    private List<CardProduct> product;

    public Order() {
        this.product = new ArrayList<>();
    }

    public Order(int id, Client client, String address, OrderStatus status, double total,
                 String payment, List<CardProduct> product) {
        this.id = id;
        this.client = client;
        this.address = address;
        this.orderTime = LocalDateTime.now();
        this.status = status;
        this.total = total;
        this.payment = payment;
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

    public void setProduct(List<CardProduct> product) {
        this.product = product;
    }

    public String getFormattedDate() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(orderTime);
    }

    public String getFormattedTime() {
        return DateTimeFormatter.ofPattern("hh:mm").format(orderTime);
    }

    private String print() {
        StringBuilder sb = new StringBuilder();
        for (CardProduct prod : product) {
            sb.append(String.format("🛍️ %s (Qty: %d, Price: $%.2f)\n", prod.getProductName(), prod.getQuantity(), prod.getPrice()));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------\n")
        .append("🧾 Order Summary\n")
        .append("--------------------------------------------------\n")
        .append(String.format("📦 Order ID      : %s\n", id))
        .append(String.format("👤 Client        : %s\n", client.getName()))
        .append(String.format("📍 Address       : %s\n", address))
        .append(String.format("🕒 Order Time    : %s %s\n", getFormattedDate(), getFormattedTime()))
        .append(String.format("📌 Status        : %s\n", status))
        .append(String.format("💰 Total Amount  : $%.2f\n", total))
        .append(String.format("💳 Payment Method: %s\n", payment))
        .append(String.format("🛒 Products      : %s\n", print()))
        .append("--------------------------------------------------\n");
        return sb.toString();
    }
}
