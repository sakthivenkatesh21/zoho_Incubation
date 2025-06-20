// package zohoincubation.com.zoho.ecommerce.src.view;

// import java.util.Scanner;

// import zohoincubation.com.zoho.ecommerce.src.model.Client;
// import zohoincubation.com.zoho.ecommerce.src.model.Seller;
// import zohoincubation.com.zoho.ecommerce.src.model.User;

// public class ViewOrders implements Operation {

//     @Override
//     public String getfunctionName() {
//         return "View Orders";
//     }

//     @Override
//     public void operation(Scanner sc, User loggedInUser) {
//         if(loggedInUser.getId() == 1){
//             dispalyClientOrders(sc,loggedInUser);
//         }
//         else if(loggedInUser.getId() == 2){
//             displaySellerOrders(sc, loggedInUser);
//         }
//         else {
//             System.out.println("You are not authorized to view orders.");
//         }
//     }


//     // private void dispalyClientOrders(Scanner sc, User loggedInUser) {
//     //     System.out.println("Displaying orders for client: " + loggedInUser.getName());
//     //     if(((Client)loggedInUser).getPreviousOrderProduct() == null || ((Client)loggedInUser).getPreviousOrderProduct().isEmpty()) {
//     //         System.out.println("No previous orders found for this client.");
//     //         return;
//     //     }
//     //     for(int i = 0; i < ((Client)loggedInUser).getPreviousOrderProduct().size(); i++) {
//     //         System.out.println("Order " + (i + 1) + ": " + ((Client)loggedInUser).getPreviousOrderProduct().get(i));
//     //     }

//     // }

//     // private void displaySellerOrders(Scanner sc, User loggedInUser) {
//     //     System.out.println("Displaying Placed  orders for seller: " + loggedInUser.getName());
//     //     if(((Seller)loggedInUser).getSaledList() == null || ((Seller)loggedInUser).getSaledList().isEmpty()) {
//     //         System.out.println("No orders found for this seller.");
//     //         return;
//     //     }
//     //     for(int i = 0; i < ((Seller)loggedInUser).getSaledList().size(); i++) {
//     //         System.out.println("Order Saled " + (i + 1) + ": " + ((Seller)loggedInUser).getSaledList().get(i));
//     //     }
//     // }

// }
