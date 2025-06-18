package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class ProductController {
    private static int idGenerator;
    private static List<Product> products = DataManager.getDataManager().getProduct();

    public static Product createProduct(String productName, String productDescription, double price,int stock, Category category, User loggedInUser) {
        if(isProductExists(productName)) {
            return null;
        }

        Product newProduct = new Product();
        newProduct.setId(++idGenerator);
        newProduct.setProductName(productName);
        newProduct.setDescription(productDescription);
        newProduct.setPrice(price);
        newProduct.setStock(stock); 
        newProduct.setCategory(category);
        newProduct.setSeller((Seller)loggedInUser);

        products.add(newProduct);
        category.getProduct().add(newProduct);
        return newProduct;
        
    }
    public static Product isProductExist(int productId) {
        for(Product obj : products) {
            if (obj.getId() == productId) {
                return obj;
            }
        }
        return null;
    }
    public static boolean isProductExists(String productname) {
        for(Product obj : products) {
            if (obj.getProductName().equals(productname)) {
                return true;
            }
        }
        return false;
    }






    // private static int idGenerator(){
    //     Random rand = new Random();
    //     int id; 
    //     do{
    //         id = rand.nextInt(1,99);
    //     }while(!uniqueId(id));
    //     return id; 
    // }
    // private static boolean uniqueId(int id){
    //     if(products.isEmpty()){
    //         return true;
    //     }
    //     for(Product obj : products){
    //         if(obj.getId() == id){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
