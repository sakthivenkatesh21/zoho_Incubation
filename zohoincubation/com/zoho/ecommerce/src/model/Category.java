package zohoincubation.com.zoho.ecommerce.src.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    
    private int id ;
    private String name ;
    private String description;
    private List<Product> product;

    public Category(){
        product = new ArrayList<>();
    }

    public Category(int id, String name, String description, List<Product> product) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "\n CategoryId=" + id + ",\n Name=" + name + ",\n Description=" + description + "\n";
    }

}
