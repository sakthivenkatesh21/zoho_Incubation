package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.CategoryController;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Editable;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Execute;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Viewable;
import zohoincubation.com.zoho.ecommerce.src.model.Category;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class CategoryHelper implements Execute, Editable, Viewable {
    private Scanner sc;
    private User loggedInUser;

    public CategoryHelper(Scanner sc, User loggedInUser) {
        this.sc = sc;
        this.loggedInUser = loggedInUser;
    }

    @Override
    public String getfunctionName() {
        return "Add Category";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {
        System.out.println("Welcome to Category Management");
        System.out.println("Seller Name : " + loggedInUser.getName());
        while (true) {
            System.out.println("1.Add Category \n2.View Categories \n3.Delete Category \n4.Update Category\n5.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    System.out.println("Exiting Category Management.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void add() {
        Object[] data = getDetails();
        if (CategoryController.createCategory(data[0].toString(), data[1].toString()) != null)
            System.out.println("Category Created Successfully");
        else
            System.out.println("Category with name '" + data[0].toString() + "' already exists.");
    }

    public void view() {
        if (CategoryController.isCategoryEmpty()) {
            System.out.println("No categories available. Please add a category first.");
            return;
        }
        System.out.println("Available Categories:");
        for (int i = 0; i < CategoryController.getCategories().size(); i++) {
            System.out.println((i + 1) + ". " + CategoryController.getCategories().get(i).getName());
        }
    }

    public void update() {
        if (CategoryController.isCategoryEmpty()) {
            System.out.println("No categories available to update.");
            return;
        }
        int categoryIndex = checkCategory();
        if (categoryIndex == -1) {
            System.out.println("Invalid category selected.");
            return;
        }
        Category category = CategoryController.getCategories().get(categoryIndex);
        System.out.println("You are about to update the category: " + category.getName());
        Object[] data = getDetails();
        Category obj = CategoryController.UpdateCategory(category, data[0].toString(), data[1].toString());
        if (obj == null) {
            System.out.println("Failed to update category. Please try again.");
        } else {
            System.out.println("Category updated successfully : \n " + obj);
        }
    }

    public void delete() {
        if (CategoryController.isCategoryEmpty()) {
            System.out.println("No categories available to delete.");
            return;
        }
        int categoryIndex = checkCategory();
        if (categoryIndex == -1) {
            System.out.println("Invalid category selected.");
            return;
        }
        System.out.println("You have selected to delete the category: " + CategoryController.getCategories().get(categoryIndex).getName());
        System.out.println("Are you sure you want to delete this category? \n This action can delete Your Product List Completly \n \t(yes/no) || (y/n)");
        String confirmation = sc.nextLine().trim().toLowerCase();
        if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
            if (CategoryController.removeCategory(CategoryController.getCategories().get(categoryIndex))) {
                System.out.println("Category deleted successfully.");
            } else {
                System.out.println("Failed to delete category. Please try again.");
            }
        } else {
            System.out.println("Category deletion cancelled.");
        }
    }

    public static Category getCategory(Scanner sc) {
        if (CategoryController.isCategoryEmpty()) {
            return null;
        }
        System.out.println("Available Categories:");
        for (int i = 0; i < CategoryController.getCategories().size(); i++) {
            System.out.println((i + 1) + ". " + CategoryController.getCategories().get(i).getName());
        }
        int categoryIndex;
        do {
            System.out.println("Select a category by entering the corresponding number:");
            categoryIndex = sc.nextInt() - 1;
            sc.nextLine();
        } while (categoryIndex < 0 || categoryIndex >= CategoryController.getCategories().size());

        return CategoryController.getCategories().get(categoryIndex);
    }

    private int checkCategory() {
        view();
        System.out.println("Enter the number of the category you want :");
        int categoryIndex = sc.nextInt() - 1;
        sc.nextLine();
        if (categoryIndex < 0 || categoryIndex >= CategoryController.getCategories().size()) {
            System.out.println("Invalid category number. Please try again.");
            return -1;
        }
        return categoryIndex;
    }

    private Object[] getDetails() {
        System.out.println("Enter the Category Name");
        String categoryName = sc.nextLine();
        System.out.println("Enter the Category Description");
        String categoryDescription = sc.nextLine();
        return new Object[]{categoryName, categoryDescription};
    }
}
