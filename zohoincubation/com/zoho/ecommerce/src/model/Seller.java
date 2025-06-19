package zohoincubation.com.zoho.ecommerce.src.model;

import java.util.ArrayList;
import java.util.List;

import zohoincubation.com.zoho.ecommerce.src.view.AddCategory;
import zohoincubation.com.zoho.ecommerce.src.view.AddProduct;
import zohoincubation.com.zoho.ecommerce.src.view.CheckOut;
import zohoincubation.com.zoho.ecommerce.src.view.Operation;
import zohoincubation.com.zoho.ecommerce.src.view.ViewCategory;
import zohoincubation.com.zoho.ecommerce.src.view.ViewProduct;

public class Seller extends User {
    
    private int soldItem;
    private double profit;
    private String company;
    private String companyAddress;
    private List<Product> sellerProduct;
    private List<CardProduct> saledList; 
    
    public Seller(){
        // this.operations = new Operation[]{
        //     new AddCategory(),
        //     new ViewCategory(),
        //     new AddProduct(),
        //     new ViewProduct(),
        //     new CheckOut(),
            
        // };
    }

    public Seller(int id, String name,String phone, String email,
                    String password, String gender,int soldItem, 
                    double profit, String company, String companyAddress){
        super(id, name, phone, email, password, gender);
        this.soldItem = soldItem;
        this.profit = profit;
        this.company = company;
        this.companyAddress = companyAddress;
        this.sellerProduct = new ArrayList<>();;
        this.saledList = new ArrayList<>();;
    }
    private void list(){
        this.operations = new Operation[]{
            new AddCategory(),
            new ViewCategory(),
            new AddProduct(),
            new ViewProduct(),
            
        };
    }
    protected Operation[] getOperations() {
        if (this.operations == null) {
            list();
        }
        return this.operations;
    }

    public int getSoldItem() {
        return soldItem;
    }

    public void setSoldItem(int soldItem) {
        this.soldItem = soldItem;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<Product> getSellerProduct() {
        return sellerProduct;
    }

    public void setSellerProduct(List<Product> sellerProduct) {
        this.sellerProduct = sellerProduct;
    }

    public List<CardProduct> getSaledList() {
        return saledList;
    }

    public void setSaledList(List<CardProduct> saledList) {
        this.saledList = saledList;
    }

    public int getRole(){
        return 2;
    }
    
    public String toString() {
        return "Seller ID : " + getId() + "\n" +
               "Name : " + getName() + "\n" +
               "Phone : " + getPhone() + "\n" +
               "Email : " + getEmail() + "\n" +
               "Company : " + company + "\n" +
               "Company Address : " + companyAddress + "\n" +
               "Sold Items : " + soldItem + "\n" +
               "Profit : " + profit;
    }
}
