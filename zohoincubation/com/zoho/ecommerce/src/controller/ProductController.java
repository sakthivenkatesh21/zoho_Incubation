package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.ArrayList;
import java.util.List;
import zohoincubation.com.zoho.ecommerce.src.model.CardProduct;
import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class ProductController {
    private static int idGenerator;
    private static List<Product> products = DataManager.getDataManager().getProduct();

    public static Product createProduct(String productName, String productDescription, double price, int stock, Category category, User loggedInUser) {
        if (!products.isEmpty() && isProductExists(productName,loggedInUser) != null) {
            return null;
        }
        Product newProduct = new Product(++idGenerator, productName, productDescription, price, stock, category, (Seller) loggedInUser);
        products.add(newProduct);
        category.getProduct().add(newProduct);
        return newProduct;
    }

    public static boolean updateProduct(int id, String productName, String productDescription, double price, int stock) {
        Product product = isProductExist(id);
        if (product != null) {
            product.setProductName(productName);
            product.setDescription(productDescription);
            product.setPrice(price);
            product.setStock(stock);
            return true;
        }
        return false;
    }

    public static boolean removeProduct(Product product) {
        if (product != null) {
            products.remove(product);
            Category category = product.getCategory();
            if (category != null) {
                category.getProduct().remove(product);
                return true;
            }
        }
        return false;
    }

    public static Product isProductExist(int productId) {
        for (Product obj : products) {
            if (obj.getId() == productId) {
                return obj;
            }
        }
        return null;
    }

    public static Product isProductExists(String productName, User loggedInUser) {
        for (Product obj : products) {
            if (obj.getProductName().equals(productName) && obj.getSeller().getId() == loggedInUser.getId()) {
                return obj;
            }
        }
        return null;
    }
    public static List<Product> isProductExists(String productName) {
        List<Product> searchProducts = new ArrayList<>();
        for (Product obj : products) {
            if (obj.getProductName().equals(productName)) {
                searchProducts.add(obj);
            }
        }
        return searchProducts.isEmpty() ? null : searchProducts;
    }
      

    public static boolean removeProductByCategory(List<Product> productList) {
        if (productList.isEmpty()) {
            for (Product obj : productList) {
                if (products.contains(obj)) {
                    products.remove(obj);
                }
            }
            return true;
        }
        return false;
    }
    public static List<Product> getSellerProducts(Category category , User loggedInUser) {
        List<Product> selleProducts = new ArrayList<>();
         for (Product obj : category.getProduct()) {
            if (obj.getSeller().getId() == ((Seller) loggedInUser).getId()) {
                selleProducts.add(obj);
            }
        }
        return selleProducts;
    }
    public static   boolean isProductExistCard(List<CardProduct> product , int id) {
        for (CardProduct obj : product) {
            if (obj.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
