package zohoincubation.com.zoho.ecommerce.src.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private List<Product> product;

    public Card() {
        product = new ArrayList<>();
    }
    public Card(List<Product> product) {
        this.product = product;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public double claculateCardTotal(){
        double total  =0;
        for(Product prod : product)
            total +=prod.getStock()*prod.getPrice();
        return total;    
    }

    
}
