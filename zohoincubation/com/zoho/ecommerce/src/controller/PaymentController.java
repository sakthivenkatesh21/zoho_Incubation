package zohoincubation.com.zoho.ecommerce.src.controller;

import zohoincubation.com.zoho.ecommerce.src.internal.Gpay;
import zohoincubation.com.zoho.ecommerce.src.internal.MayPay;
import zohoincubation.com.zoho.ecommerce.src.internal.Paytm;
import zohoincubation.com.zoho.ecommerce.src.view.IPaymentGateway;
import zohoincubation.com.zoho.ecommerce.src.view.PaymentProcessing;

public class PaymentController {
    private static PaymentProcessing paymentProcessing;

    public static String pay( double amount, String paymentMethod,String creditionals) {
        switch (paymentMethod) {
            case "GPay" :return process(new Gpay(amount, paymentMethod, creditionals));               
            case "Paytm":return process(new Paytm(amount, paymentMethod, creditionals));
            default:
                System.out.println("Invalid Payment Processing");
                return null;
        }
    }

    private static String process(IPaymentGateway paymentGateway) {
        paymentProcessing = new PaymentProcessing(paymentGateway);
        return paymentProcessing.processPayment();
    }

    public static String  pay( double amount, String paymentMethod, String creditionals,String ViaMode) {

        switch (ViaMode) {
            case "Card"      :return process(new MayPay(amount, ViaMode, creditionals));
            case "Upi"       :return process(new MayPay(amount, ViaMode, creditionals));
            case "NetBanking":return process(new MayPay(amount, ViaMode, creditionals));
            default:          
                System.out.println("Invalid Payment Proceesing Mode");
                return null;
        }
    }
}
