package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;
import zohoincubation.com.zoho.ecommerce.src.controller.OrderController;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Execute;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.Viewable;
import zohoincubation.com.zoho.ecommerce.src.model.Card;
import zohoincubation.com.zoho.ecommerce.src.model.Client;
import zohoincubation.com.zoho.ecommerce.src.model.Order;
import zohoincubation.com.zoho.ecommerce.src.model.Seller;
import zohoincubation.com.zoho.ecommerce.src.model.User;

public class OrderHelper implements Execute, Viewable {
  private Scanner sc;
  private User loggedInUser;

  public OrderHelper(Scanner sc, User loggedInUser) {
    this.sc = sc;
    this.loggedInUser = loggedInUser;
  }

  @Override
  public String getfunctionName() {
    return "Order Management";
  }

  @Override
  public void operation(Scanner sc, User loggedInUser) {
    while (true) {
      if (loggedInUser.getRole() == 2)
        System.out.println("1. View Orders\n0. Exit");
      else
        System.out.println("1. Checkout\n2. View Order\n0. Exit");
      System.out.println("Enter a choice");
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          if (loggedInUser.getRole() == 2)
            view();
          else
            checkout();
          break;
        case 2:
           if (loggedInUser.getRole() == 1) view();
          break;
        case 0:
          System.out.println("Exiting Order Management.");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private void checkout() {
    if (((Client) loggedInUser).getcard() == null || ((Client) loggedInUser).getcard().getProduct() == null || ((Client) loggedInUser).getcard().getProduct().isEmpty()) {
      System.out.println("You must have a valid card to check out. Please add Product to a card And checkout your account.");
      return;
    }

    if (loggedInUser instanceof Client) {
      Card card = ((Client) loggedInUser).getcard();
      WishlistHandler wishlistHandler = new WishlistHandler(sc, loggedInUser);
      wishlistHandler.view();
      System.out.println("Enter 'Yes | Y ' to confirm checkout\n\t OR\n'No | N' Remove Product From Card:");
      String choice = sc.nextLine().trim().toUpperCase();

      if (choice.equals("NO") || choice.equals("N")) {
        wishlistHandler.delete();
      }
      else if (choice.equals("YES") || choice.equals("Y")) {
        System.out.println("Proceeding to checkout...");
        wishlistHandler.checkQuantityExist(card.getProduct());
        double cardTotal = card.calculateCardTotal();
        String payment = PaymentHelper.paymentProcess(sc, cardTotal);
        if (payment == null) {
          System.out.println("Payment failed. Please try again.");
          return;
        }
        Order order = OrderController.createOrder(card, cardTotal, payment, loggedInUser);
        if (order != null) 
          OrderStatusUpdate.flow(order);
        else  
          System.out.println("Order creation failed. Please try again.");     
      }else 
        System.out.println("Invalid choice. Please enter 'Yes' or 'No'.");  
    }
  }

  public void view() {
    if (loggedInUser.getRole() == 1) {
      dispalyClientOrders(sc, loggedInUser);
    } else if (loggedInUser.getRole() == 2) {
      displaySellerOrders(sc, loggedInUser);
    } else {
      System.out.println("You are not authorized to view orders.");
    }
  }

  private void dispalyClientOrders(Scanner sc, User loggedInUser) {
    System.out.println("Displaying orders for client: " + loggedInUser.getName());
    if (((Client) loggedInUser).getPreviousOrderProduct() == null || ((Client) loggedInUser).getPreviousOrderProduct().isEmpty()) {
      System.out.println("No previous orders found for this client.");
      return;
    }
    for (int i = 0; i < ((Client) loggedInUser).getPreviousOrderProduct().size(); i++) {
      System.out.println("Order " + (i + 1) + ": " + ((Client) loggedInUser).getPreviousOrderProduct().get(i));
    }
  }

  private void displaySellerOrders(Scanner sc, User loggedInUser) {
    System.out.println("Displaying Placed orders for seller: " + loggedInUser.getName());
    if (((Seller) loggedInUser).getSaledList() == null || ((Seller) loggedInUser).getSaledList().isEmpty()) {
      System.out.println("No orders found for this seller.");
      return;
    }
    for (int i = 0; i < ((Seller) loggedInUser).getSaledList().size(); i++) {
      System.out.println("Order Saled " + (i + 1) + ": " + ((Seller) loggedInUser).getSaledList().get(i));
    }
  }
}
