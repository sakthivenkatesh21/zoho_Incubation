package zohoincubation.com.zoho.ecommerce.src.model;

public class Product {

    private int id;
    private String productName;
    private String description ;
    private double price;
    private int stock;
    private Category category;
    private Seller seller;
    
    public Product() {
    }
    
    public Product(int id, String productName, String description, double price, 
                        int stock, Category category,Seller seller) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.seller = seller;
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        System.out.println("Product ID: " + getId());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Product Price: " + getPrice());
        System.out.println("Product Quantity: " + getStock());
        System.out.println("Product Description: " + getDescription());
        System.out.println("Seller Name: " + getSeller().getName());
        System.out.println("-----------------------------");
        return"";
    }

}
