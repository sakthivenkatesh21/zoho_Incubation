package zohoincubation.com.zoho.ecommerce.src.model;

public class Product {

    private int id;
    private String productName;
    private String description ;
    private double price;
    private int stock;
    private Category category;
    private Seller selller;
    
    public Product() {
    }

    public Product(int id, String productName, String description, double price, int stock, Category category,
            Seller selller) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.selller = selller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public boolean isAvailableStock(){
        return stock>0;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getSelller() {
        return selller;
    }

    public void setSelller(Seller selller) {
        this.selller = selller;
    }

}
