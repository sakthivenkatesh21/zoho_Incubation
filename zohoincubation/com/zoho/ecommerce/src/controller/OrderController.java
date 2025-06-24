package zohoincubation.com.zoho.ecommerce.src.controller;

import java.util.List;
import zohoincubation.com.zoho.ecommerce.src.model.Card;
import zohoincubation.com.zoho.ecommerce.src.model.CardProduct;
import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Order;
import zohoincubation.com.zoho.ecommerce.src.model.OrderStatus;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class OrderController {
   
    private static int  idGenerator;
    private static final List<Order> orders = DataManager.getDataManager().getOrders();

    public static boolean isOrderEmpty() {
        return orders.isEmpty();
    }

    public  static Order  createOrder(Card card, double amount,String payment, User loggedInUser) {
       
        Order order = new Order(++idGenerator,(Client)loggedInUser,((Client)loggedInUser).getAddress(),
                                    OrderStatus.CONFIRMED,amount,payment);
        updateSellerSales(card.getProduct());
        productOrder(order.getProduct(), card.getProduct());
        // order.setProduct(productlist);
        // card.getProduct().clear();
        orders.add(order);
        
        ((Client)loggedInUser).getPreviousOrderProduct().add(order);
        return order;
        
    }
    private static void updateSellerSales(List<CardProduct> products) {
        for(CardProduct product : products) {
            product.getSeller().setSoldItem(product.getSeller().getSoldItem() + 1);
            product.getSeller().setProfit(product.getSeller().getProfit() +(product.getPrice()*product.getQuantity()));
            product.getSeller().getSaledList().add(product);
        }
    }

    private  static List<CardProduct>  productOrder(List<CardProduct> orderProducts, List<CardProduct> cardProducts) {
        for (CardProduct product : cardProducts) {    
                orderProducts.add(product);
                cardProducts.remove(product);
        }   
        return orderProducts;
    }

}
