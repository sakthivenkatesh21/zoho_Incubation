package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;

import zohoincubation.com.zoho.ecommerce.src.controller.PaymentController;

public class PaymentHelper {
    public static String paymentProcess(Scanner sc, double amount) {
        System.out.println("Your total amount is: " + amount);
        System.out.println("Payment options available: \n 1.Paytm \n 2.GPay \n 3.MayPay");
        int paymentOption = sc.nextInt();
        sc.nextLine();
        switch (paymentOption) {
            case 1:
                System.out.println("Processing payment through Paytm...");
                System.out.println("Enter your Paytm Wallet ID:");
                String walletId = sc.nextLine();
                return PaymentController.pay(amount, "Paytm", walletId);

            case 2:
                System.out.println("Processing payment through GPay...");
                System.out.println("Enter your GPay ID:");
                String gpayId = sc.nextLine();
                return PaymentController.pay(amount, "GPay", gpayId);

            case 3:
                return maybePay(sc, amount);

            default:
                System.out.println("Invalid payment option selected. Please try again.");
                return null;
        }
    }

    private static String maybePay(Scanner sc, double amount) {
        System.out.println("Processing payment through MayPay...");
        System.out.println("Payment methods available: \n1. Card \n2. UPI \n3. NetBanking");
        int paymentMode = sc.nextInt();
        sc.nextLine();
        switch (paymentMode) {
            case 1:
                System.out.println("Enter your card details (Card Number):");
                String cardDetails = sc.nextLine();
                return PaymentController.pay(amount, "MayPay", cardDetails, "Card");

            case 2:
                System.out.println("Enter your MayPay ID:");
                String mayPayId = sc.nextLine();
                return PaymentController.pay(amount, "MayPay", mayPayId, "Upi");

            case 3:
                System.out.println("Enter your bank details for NetBanking:");
                String netBanking = sc.nextLine();
                return PaymentController.pay(amount, "MayPay", netBanking, "NetBanking");

            default:
                System.out.println("Invalid payment mode selected. Please try again.");
                return null;
        }
    }
}
