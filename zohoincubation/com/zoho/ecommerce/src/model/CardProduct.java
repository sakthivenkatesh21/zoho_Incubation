package zohoincubation.com.zoho.ecommerce.src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CardProduct extends Product {

    private int quantity;
    private LocalDateTime prodTimeDateAdded;
    private OrderStatus producStatus;

    public CardProduct() {}

    public CardProduct(int id, Product product, int quantity) {
        super(id, product.getProductName(), product.getDescription(), product.getPrice(), 
              product.getStock(), product.getCategory(), product.getSeller());
        this.quantity = quantity;
        this.prodTimeDateAdded = LocalDateTime.now();
        this.producStatus = OrderStatus.PENDING;
    }

    public CardProduct(int quantity, LocalDateTime prodTimeDateAdded, OrderStatus producStatus) {
        this.quantity = quantity;
        this.prodTimeDateAdded = prodTimeDateAdded;
        this.producStatus = producStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getprodTimeDateAdded() {
        return prodTimeDateAdded;
    }

    public void setprodTimeDateAdded(LocalDateTime prodTimeDateAdded) {
        this.prodTimeDateAdded = prodTimeDateAdded;
    }

    public String getFormattedDate() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(prodTimeDateAdded);
    }

    public String getFormattedTime() {
        return DateTimeFormatter.ofPattern("hh:mm").format(prodTimeDateAdded);
    }

    public OrderStatus getProducStatus() {
        return producStatus;
    }

    public void setProducStatus(OrderStatus producStatus) {
        this.producStatus = producStatus;
    }

    public boolean canAddToCard() {
        return getStock() >= getQuantity();
    }

    public boolean reStock() {
        if(canAddToCard()){
            setStock( getStock()-getQuantity());
            return true;
        }
        return false;
    }
}
