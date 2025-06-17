package zohoincubation.com.zoho.ecommerce.src.model;

import java.util.ArrayList;
import java.util.List;

public class Seller  {
    
    private int soldItem;
    private double profit;
    private String company;
    private String companyAddress;
    private List<Product> sellerProduct;
    private List<Order> saledList; 
    
    public Seller(){
        sellerProduct = new ArrayList<>();
    }

    public Seller(int soldItem, double profit, String company, String companyAddress, List<Product> sellerProduct,
            List<Order> saledList) {
        this.soldItem = soldItem;
        this.profit = profit;
        this.company = company;
        this.companyAddress = companyAddress;
        this.sellerProduct = sellerProduct;
        this.saledList = saledList;
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

    public List<Order> getSaledList() {
        return saledList;
    }

    public void setSaledList(List<Order> saledList) {
        this.saledList = saledList;
    }

    

}
