package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import zohoincubation.com.zoho.ecommerce.src.controller.ProductController;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Creatable;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Deletable;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Editable;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Execute;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Viewable;
import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Product;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class ProductHelper implements Execute, Creatable, Editable, Viewable, Deletable {
    private final Scanner sc;
    private final User loggedInUser;
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
            System.out.println("=========================================");
            System.out.println("          🛍️ Product Management Menu        ");
            System.out.println("=========================================");
            if (loggedInUser.getRole() == 1) {
                System.out.println("1. 🔍 View Products");
                System.out.println("0. 🔙 Back (Exit)");
            } else {
                System.out.println("1. ➕ Add Product");
                System.out.println("2. 🔍 View Product");
                System.out.println("3. ✏️ Update Product");
                System.out.println("4. ❌ Remove Product");
                System.out.println("0. 🔙 Back (Exit)");
            }
            System.out.println("=========================================");
            System.out.print("Enter your choice: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        if (loggedInUser.getRole() == 1)
                            view();
                        else add();
                    }
                    case 2 -> view();
                    case 3 -> update();
                    case 4 -> delete();
                    case 0 -> {
                        System.out.println("🔙 Exiting to previous menu.");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice. Please try again.");
                }
            }catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("❌ An unexpected error occurred: " + e.getMessage());
            }

        }
    }
        
   

    @Override
    public void add() {
        if ((loggedInUser instanceof Client)) {
            System.out.println("🚫 You are not authorized to add a product. Only sellers can add products.");
            return;
        }
        category = CategoryHelper.getCategory(sc);
        if (category == null) {
            System.out.println("⚠️ No category available. Please add a category first.");
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
            System.out.println("❌ Product with the same name already exists.");
        } else {
            System.out.println("✅ Product added successfully: " + product.getProductName());
        }
    }

    @Override
    public void view() {
        category = CategoryHelper.getCategory(sc);
        if (category == null || category.getProduct().isEmpty()) {
            System.out.println("⚠️ No product is available.");
            return;
        }
        if (loggedInUser.getRole() == 2) {
            showCategoryProducts(category);
            return;
        }
        while (true) {
            System.out.println("************************************************");
            System.out.println("*                                              *");
            System.out.println("*          🛍️ Product Options Menu                *");
            System.out.println("*                                              *");
            System.out.println("************************************************");
        
            System.out.println("Choose an option:");
            System.out.println("------------------------------------------------");
            System.out.println("1. 🔍 View Products");
            System.out.println("2. 🔎 Search Product");
            System.out.println("3. ❤️ Add to Wish List");
            System.out.println("0. 🔙 Back (Exit)");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> showCategoryProducts(category);
                    case 2 -> search();
                    case 3 -> {
                        if (loggedInUser.getRole() == 1)
                            addWishList(category);
                    }
                    case 0 -> {
                        System.out.println("🔙 Exiting to previous menu.");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("❌ An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    @Override
    public void update() {
        Product product = checkProduct();
        if (product != null) {
            System.out.println("📝 Current Product Details: " + product);
            Object[] data = getDetails();
            if (ProductController.updateProduct(
                product.getId(),
                data[0].toString(),
                data[1].toString(),
                Double.parseDouble(data[2].toString()),
                Integer.parseInt(data[3].toString())
            )) {
                System.out.println("✅ Product updated successfully: " + product);
            } else {
                System.out.println("❌ Product not found or could not be updated.");
            }
        }
    }

    @Override
    public void delete() {
        Product product = checkProduct();
        if (product != null) {
            if (ProductController.removeProduct(product)) {
                System.out.println("✅ Product removed successfully: " + product.getProductName());
            } else {
                System.out.println("❌ Product not found or could not be removed.");
            }
        }
    }

    private Object[] getDetails() {
        ValidData validator = new ValidData(sc);
        System.out.println("📝 Enter the new Product Name:");
        String productName = validator.name();
        System.out.println("📝 Enter the new Product Description:");
        String productDescription =validator.name();
        System.out.println("💰 Enter the new Product Price:");
        double productPrice = sc.nextDouble() ;
        while(productPrice> 0 ){
            System.out.println("❌ Invalid price! Please enter a valid price greater than 0.");
            productPrice = sc.nextDouble();
        }
        System.out.println("📦 Enter the new Product Stock:");
        int productStock = sc.nextInt();
        while(productStock <=0 || productStock >100){
            System.out.println("❌ Invalid stock! Please enter a valid stock between 0 and 100.");
            productStock = sc.nextInt();
        }
        sc.nextLine();
        return new Object[] { productName, productDescription, productPrice, productStock };
    }

    private Product checkProduct() {
        if (loggedInUser.getRole() == 1) {
            System.out.println("🚫 You are not authorized to update a product. Only sellers can update products.");
            return null;
        }
        category = CategoryHelper.getCategory(sc);
        if (category == null || category.getProduct().isEmpty()) {
            System.out.println("⚠️ No product is available.");
            return null;
        }
        showCategoryProducts(category);
        System.out.println("🆔 Enter the Product ID to update or 0 to exit:");
        int productId = sc.nextInt();
        sc.nextLine();
        if (productId == 0) {
            System.out.println("🔙 Exiting to previous menu.");
            return null;
        } else {
            Product product = ProductController.isProductExist(productId);
            if (product != null && category.getProduct().contains(product)) {
                return product;
            } else {
                System.out.println("❌ Product not found in the selected category.");
                return null;
            }
        }
    }

    private void search() {
        System.out.println("🔎 Enter a Product Name to search:");
        String productName = sc.nextLine();
        List<Product> product = ProductController.isProductExists(productName);
        if (product == null) {
            System.out.println("❌ Product not found. Please try again.");
            return;
        }
        for (Product obj : product) {
            System.out.println("✅ Product found in Category: " + obj.getCategory().getName());
            System.out.println("📝 Product Details: \n \t " + obj);
        }
        System.out.println("****************************************");
        System.out.println("*                                      *");
        System.out.println("*        🔎 Product Search Options        *");
        System.out.println("*                                      *");
        System.out.println("****************************************");
        System.out.println("1. ❤️ Add to Wish List");
        System.out.println("2. 🔎 Search Product Again");
        System.out.println("3. 🔙 Back (Exit)");
        System.out.println("****************************************");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1 -> {
                if (!addingProductToCart())
                    System.out.println("🔙 Exiting to previous menu.");
            }
            case 2 -> search();
            default -> System.out.println("🔙 Exiting to previous menu.");
        }
    }

    private void addWishList(Category category) {
        if (loggedInUser.getRole() == 2) {
            System.out.println("🚫 You are not authorized to add products to the cart. Only buyers can add products to the cart.");
            return;
        }
        while (true) {
            showCategoryProducts(category);
            if (!addingProductToCart()) {
                System.out.println("🔙 Exiting to previous menu.");
                return;
            }
        }
    }

    private boolean addingProductToCart() {
        System.out.println("🆔 Enter the Product ID to add to cart or 0 to exit:");
        int productId = sc.nextInt();
        sc.nextLine();
        if (productId == 0) return false;
        Product product = ProductController.isProductExist(productId);
        if (product == null && !category.getProduct().contains(product)) {
            System.out.println("❌ Product not found in the selected category.");
            return false;
        }
        WishlistHandler addCard = new WishlistHandler(product, sc, loggedInUser);
        addCard.add();
        return true;
    }

    private void showCategoryProducts(Category category) {
        System.out.println("🛍️ Products in Category: " + category.getName() + "\n");

        if (loggedInUser.getRole() == 2) {
            List<Product> product = ProductController.getSellerProducts(category, loggedInUser);
            if (product.isEmpty()) {
                System.out.println("⚠️ No products found for the logged-in seller in this category.");
                return;
            }
            System.out.println("🆔 Seller ID: " + ((Seller) loggedInUser).getId() + " 🧑‍💼 Seller Name: " + ((Seller) loggedInUser).getName());
            System.out.println();
            System.out.println("🛍️ Seller Products: ");
            for (Product obj : product) {
                System.out.println(obj);
            }
        } else if (loggedInUser.getRole() == 1) {
            for (Product product : category.getProduct()) {
                System.out.println(product);
            }
        }
    }
}
