package zohoincubation.com.zoho.ecommerce.src.view;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.ProductController;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Editable;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Execute;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Viewable;
import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;
import zohoincubation.com.zoho.ecommerce.src.model.Client;

public class ProductHelper implements Execute,Editable,Viewable {
    private Scanner sc;
    private User loggedInUser;
    private Category category;

    public ProductHelper(Scanner sc, User loggedInUser) {
        this.sc = sc;
        this.loggedInUser = loggedInUser;
    }

    @Override
    public String getfunctionName() {
        return "Product Management";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {
        while (true) {
            if (loggedInUser.getRole() == 1) {
                System.out.println("1.View Products\n0.Back(Exit)");
            } else {
                System.out.println("1.Add Product\n2.View Product\n3.Update Product\n4.RemoveProduct\n0.Back(Exit)");
            }
            System.out.println("Enter a choice");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (loggedInUser.getRole() == 1) {
                        view();
                    } else {
                        add();
                    }
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 0:
                    System.out.println("Exiting to previous menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void add() {
        if ((loggedInUser instanceof Client)) {
            System.out.println("You are not authorized to add a product. Only sellers can add products.");
            return;
        }
        category = CategoryHelper.getCategory(sc);
        if (category == null) {
            System.out.println("No category Available. Please Add a category first.");
            return;
        }
        Object[] data = getDetails();
        Product product = ProductController.createProduct(
            data[0].toString(),
            data[1].toString(),
            Double.parseDouble(data[2].toString()),
            Integer.parseInt(data[3].toString()),
            category,
            loggedInUser
        );
        if (product == null) {
            System.out.println("Product with the same name already exists.");
        } else {
            System.out.println("Product added successfully: " + product.getProductName());
        }
    }

    public void view() {
        category = CategoryHelper.getCategory(sc);
        if (category == null || category.getProduct().isEmpty()) {
            System.out.println("No product is Available ");
            return;
        }
        if (loggedInUser.getRole() == 2) {
            showCategoryProducts(category);
            return;
        }
        System.out.println("************************************************");
        while (true) {
            System.out.println("1.View Products\n2.Search Product\n3.Add to Wish List\n0.Back(Exit)");
            System.out.println("Enter a choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    showCategoryProducts(category);
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    if (loggedInUser.getRole() == 1) {
                        addWishList(category);
                    }
                    break;
                case 0:
                    System.out.println("Exiting to previous menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void update() {
        Product product = checkProduct();
        if (product == null) {
            return;
        } else {
            System.out.println("Current Product Details: " + product);
            Object[] data = getDetails();
            if (ProductController.updateProduct(
                product.getId(),
                data[0].toString(),
                data[1].toString(),
                Double.parseDouble(data[2].toString()),
                Integer.parseInt(data[3].toString())
            )) {
                System.out.println("Product updated successfully: " + product);
            } else {
                System.out.println("Product not found or could not be updated.");
            }
        }
    }

    public void delete() {
        Product product = checkProduct();
        if (product == null) {
            return;
        } else {
            if (ProductController.removeProduct(product)) {
                System.out.println("Product removed successfully: " + product.getProductName());
            } else {
                System.out.println("Product not found or could not be removed.");
            }
        }
    }

    private Object[] getDetails() {
        System.out.println("Enter the new Product Name");
        String productName = sc.nextLine();
        System.out.println("Enter the new Product Description");
        String productDescription = sc.nextLine();
        System.out.println("Enter the new Product Price");
        double productPrice = sc.nextDouble();
        System.out.println("Enter the new Product Stock");
        int productStock = sc.nextInt();
        sc.nextLine();
        return new Object[] { productName, productDescription, productPrice, productStock };
    }

    private Product checkProduct() {
        if (loggedInUser.getRole() == 1) {
            System.out.println("You are not authorized to update a product. Only sellers can update products.");
            return null;
        }
        category = CategoryHelper.getCategory(sc);
        if (category == null || category.getProduct().isEmpty()) {
            System.out.println("No product is Available ");
            return null;
        }
        showCategoryProducts(category);
        System.out.println("Enter the Product ID to update or 0 to exit");
        int productId = sc.nextInt();
        sc.nextLine();
        if (productId == 0) {
            System.out.println("Exiting to previous menu.");
            return null;
        } else {
            Product product = ProductController.isProductExist(productId);
            if (product != null && category.getProduct().contains(product)) {
                return product;
            } else {
                System.out.println("Product not found in the selected category.");
                return null;
            }
        }
    }

    private void search() {
        System.out.println("Enter a Product Name to search");
        String productName = sc.nextLine();
        List<Product> product = ProductController.isProductExists(productName);
        if (product == null) {
            System.out.println("Product not found. Please try again.");
            return;
        }
        for (Product obj : product) {
            System.out.println("Product found in Category: " + obj.getCategory().getName());
            System.out.println("Product Details: \n \t " + obj);
        }
        System.out.println("1.Add to Wish List\n2.Search Product Again\n3.Back(Exit)");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
           if(!addingProductToCart()){
                System.out.println("Exiting to previous menu.");
                return;
           }
        } else if (choice == 2) {
            search();
        } else {
            System.out.println("Exiting to previous menu.");
            return;
        }
    }

    private void addWishList(Category category) {
        if (loggedInUser.getRole() == 2) {
            System.out.println("You are not authorized to add products to the cart. Only buyers can add products to the cart.");
            return;
        }
        while (true) {
            showCategoryProducts(category);
            if(!addingProductToCart()){
                System.out.println("Exiting to previous menu.");
                return;
            }     
        }
    }
    private boolean addingProductToCart() {
            System.out.println("Enter the Product ID to add to cart or 0 to exit");
            int productId = sc.nextInt();
            sc.nextLine();
            if(productId == 0) return false;
            Product product = ProductController.isProductExist(productId);
            if (product == null && !category.getProduct().contains(product)) {
                System.out.println("Product not found in the selected category.");
                return false;
            }
            WishlistHandler addCard = new WishlistHandler(product,sc,loggedInUser);
            addCard.add();
                // Execute [] obj = loggedInUser.getOperations(sc, loggedInUser);
                // for(Execute operation : obj) {
                //     if (operation instanceof WishlistHandler) {
                //         WishlistHandler addCard = (WishlistHandler) operation;
                //         addCard.add();
                //         break;
                //     }
                // }
             return true;            
    }

    private void showCategoryProducts(Category category) {
        System.out.println("Products in Category: " + category.getName() + "\n");

        if (loggedInUser.getRole() == 2) {
            List<Product> product =ProductController.getSellerProducts(category, loggedInUser);
            if(product.isEmpty()) {
                System.out.println("No products found for the logged-in seller in this category.");
                return;
            }
            System.out.println("Seller ID: " + ((Seller) loggedInUser).getId() + "Seller Name: " + ((Seller) loggedInUser).getName());
            System.out.println();
            System.out.println("Seller Products: ");
            for (Product obj :product) {
                    System.out.println(obj);
            }
            
        } else if (loggedInUser.getRole() == 1){
            for (Product product : category.getProduct()) {
                System.out.println(product);
            }
        }
    }
}
