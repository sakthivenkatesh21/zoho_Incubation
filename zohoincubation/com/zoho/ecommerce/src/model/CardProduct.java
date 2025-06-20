package zohoincubation.com.zoho.ecommerce.src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CardProduct extends Product {

    private int quantity;
    private LocalDateTime prodTimeAdded;
    private OrderStatus producStatus;

    public CardProduct() {}

    public CardProduct(int id, Product product, int quantity) {
        super(id, product.getProductName(), product.getDescription(), product.getPrice(), 
              product.getStock(), product.getCategory(), product.getSeller());
        this.quantity = quantity;
        this.prodTimeAdded = LocalDateTime.now();
        this.producStatus = OrderStatus.PENDING;
    }

    public CardProduct(int quantity, LocalDateTime prodTimeAdded, OrderStatus producStatus) {
        this.quantity = quantity;
        this.prodTimeAdded = prodTimeAdded;
        this.producStatus = producStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getProdTimeAdded() {
        return prodTimeAdded;
    }

    public void setProdTimeAdded(LocalDateTime prodTimeAdded) {
        this.prodTimeAdded = prodTimeAdded;
    }

    public String getFormattedDate() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(prodTimeAdded);
    }

    public String getFormattedTime() {
        return DateTimeFormatter.ofPattern("hh:mm").format(prodTimeAdded);
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

    public void reStock() {
        setStock(getQuantity() + getStock());
    }
}
