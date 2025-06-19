package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.OrderController;
import zohoincubation.com.zoho.ecommerce.src.controller.PaymentController;
import zohoincubation.com.zoho.ecommerce.src.model.Card;
import zohoincubation.com.zoho.ecommerce.src.model.CardProduct;
import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Order;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class CheckOut  implements Operation{

    @Override
    public String getfunctionName() {
        return "Check Out";
    }

    @Override
    public void operation(Scanner sc, User loggedInUser) {
      if(loggedInUser instanceof Seller) {
          System.out.println("Only clients can check out. Sellers cannot perform this operation.");
          return;
      }

      if(((Client)loggedInUser).getcard() == null || ((Client)loggedInUser).getcard().getProduct() == null || ((Client)loggedInUser).getcard().getProduct().isEmpty()) {
           
          System.out.println("You must have a valid card to check out. Please add Product to a card And checkout your account.");
          return;
      }

      if(loggedInUser instanceof Client) {
        Card card  = ((Client) loggedInUser).getcard();
        showcardProduct(card);
        System.out.println("Enter 'Yes | Y ' to confirm checkout\n\t OR\n'No | N' Remove  Product FromCard :");
        String choice = sc.nextLine().trim().toUpperCase();

        if(choice.equals("NO") || choice.equals("N")){
          removeProductFromCard(sc,card);
        }
        else if(choice.equals("YES") || choice.equals("Y")) {
            System.out.println("Proceeding to checkout...");
            double cardTotal = card.claculateCardTotal();
            String payment = paymentProcess(sc, cardTotal);
            if(payment == null) {
                System.out.println("Payment failed. Please try again.");
                return;
            }
            Order order = OrderController.createOrder(card,cardTotal,payment,loggedInUser);
            if(order !=null ){
              OrderStatusUpdate.flow(order);
              return;   
            }
            else{
              System.out.println("Order creation failed. Please try again.");
              return;
            }  
 

        } else {
            System.out.println("Invalid choice. Please enter 'Yes' or 'No'.");
            return;
        }    

      }
    }

    private String  paymentProcess(Scanner sc, double amount) {
        System.out.println("Your total amount is: " + amount);
        System.out.println("Payment options available: \n 1.Paytm \n 2.GPay \n 3.MayPay");
        int  paymentOption = sc.nextInt();
        sc.nextLine(); 
        switch (paymentOption) {
          case 1:
            System.out.println("Processing payment through Paytm...");
            System.out.println("Enter your Paytm Wallet ID:");
            String  walletId = sc.nextLine();
            return PaymentController.pay(amount, "Paytm", walletId); 
            
          case 2:
            System.out.println("Processing payment through GPay...");
            System.out.println("Enter a your GPay ID:");
            String gpayId = sc.nextLine();
            return PaymentController.pay(amount, "GPay", gpayId);
            
          case 3:
            return maybePay(sc,amount);
              
          default:
            System.out.println("Invalid payment option selected. Please try again.");
            return null;
        }
        
    }
    private String maybePay(Scanner sc, double amount) {
      System.out.println("Processing payment through MayPay...");
      System.out.println("Payment methods available: \n1. Card \n2. UPI \n3. NetBanking");
        int paymentmode = sc.nextInt();
        sc.nextLine(); 
            switch (paymentmode) {
              case 1:
                System.out.println("Enter your card details (Card Number):");
                String cardDetails = sc.nextLine();
                return PaymentController.pay(amount, "MayPay", cardDetails,"Card");
                
              case 2:
                System.out.println("Enter your MayPay ID:");
                String mayPayId = sc.nextLine();
                return PaymentController.pay(amount, "MayPay", mayPayId,"Upi");
                
              case 3:
                System.out.println("Enter your bank details for NetBanking:");
                String netbanking = sc.nextLine();
                return PaymentController.pay(amount, "MayPay", netbanking,"NetBanking");
                
              default:
                System.out.println("Invalid payment mode selected. Please try again.");
                return null;
            }

    }

    private void showcardProduct(Card card){
      for(int i=0; i<card.getProduct().size(); i++){
          for(CardProduct product : card.getProduct()) {
              System.out.println("Product " + (i+1) + ":"+ product.getProductName()+" Price: " + product.getPrice());
              System.out.println("\tQuantity: " + product.getQuantity()+"OrderStatus: " + product.getProducStatus());
              System.out.println();
              
          }
          System.out.println("-----------------------------");
      }
    }

    private void removeProductFromCard(Scanner sc ,Card card){
      while(true) {
        showcardProduct(card);
        System.out.println("Enter the  ID to remove from the cart \n Or Enter '-1' to CheckOut ");
        int productId = sc.nextInt()-1;
        sc.nextLine(); 
        if(productId == -1) {
              System.out.println("You have chosen to proceed with checkout.");
              return;
        } 
        CardProduct cardProduct = card.getProduct().get(productId);
        card.getProduct().remove(productId);
        System.out.println("Product " + cardProduct.getProductName() + " has been removed from your cart.");
        cardProduct.reStock();
      }
    }
    
}
