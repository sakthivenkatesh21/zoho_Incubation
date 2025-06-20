package zohoincubation.com.zoho.ecommerce.src.controller;

import zohoincubation.com.zoho.ecommerce.src.internal.Gpay;
import zohoincubation.com.zoho.ecommerce.src.internal.MayPay;
import zohoincubation.com.zoho.ecommerce.src.internal.Paytm;
import zohoincubation.com.zoho.ecommerce.src.paymentCreditionals.IPaymentGateway;
import zohoincubation.com.zoho.ecommerce.src.paymentCreditionals.PaymentProcessing;

public class PaymentController {
    private static PaymentProcessing paymentProcessing;

    public static String pay(double amount, String paymentMethod, String credentials) {
        switch (paymentMethod) {
            case "GPay":
                return process(new Gpay(amount, paymentMethod, credentials));
            case "Paytm":
                return process(new Paytm(amount, paymentMethod, credentials));
            default:
                System.out.println("Invalid Payment Processing");
                return null;
        }
    }

    private static String process(IPaymentGateway paymentGateway) {
        paymentProcessing = new PaymentProcessing(paymentGateway);
        return paymentProcessing.processPayment();
    }

    public static String pay(double amount, String paymentMethod, String credentials, String viaMode) {
        switch (viaMode) {
            case "Card":
                return process(new MayPay(amount, viaMode, credentials));
            case "Upi":
                return process(new MayPay(amount, viaMode, credentials));
            case "NetBanking":
                return process(new MayPay(amount, viaMode, credentials));
            default:
                System.out.println("Invalid Payment Processing Mode");
                return null;
        }
    }
}
