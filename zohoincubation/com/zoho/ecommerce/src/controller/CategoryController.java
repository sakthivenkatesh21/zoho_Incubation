package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.model.Category;

public class CategoryController {
    private static List<Category> category = DataManager.getDataManager().getCategory();
    private static int idGenerator;
    public static boolean isCategoryEmpty() {
        return category.isEmpty();
    }

    public static boolean isCategoryExists(String categoryName) {
        for (Category obj : category) {
            if (obj.getName().equalsIgnoreCase(categoryName)) {
                return true;
            }
        }
        return false;
    }

    public static List<Category> getCategories() {
        return category;
    }

    public static Category createCategory(String categoryName, String categoryDescription) {
        if (isCategoryExists(categoryName)) {
            System.out.println("Category with name '" + categoryName + "' already exists.");
            return null;
        }
        Category newCategory = new Category();
        newCategory.setId(++idGenerator);
        newCategory.setName(categoryName);
        newCategory.setDescription(categoryDescription);
        category.add(newCategory);
        return newCategory;
    }







    
    // private static int idGenerator(){
    //     Random rand = new Random();
    //     int id; 
    //     do{
    //         id = rand.nextInt(100,999);
    //     }while(!uniqueId(id));
    //     return id; 
    // }
    // private static boolean uniqueId(int id){
    //     if(category.isEmpty()){
    //         return true;
    //     }
    //     for(Category obj : category){
    //         if(obj.getId() == id){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
