package zohoincubation.com.zoho.ecommerce.src.internal;

import zohoincubation.com.zoho.ecommerce.src.paymentCreditionals.IPaymentGateway;

public class Paytm implements IPaymentGateway {
    private final double amount;
    private final String paymentMethod;
    private final String walletId;

    public Paytm(double amount, String paymentMethod, String walletId) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.walletId = walletId;
    }

    @Override
    public void processPayment() {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid payment amount. Payment cannot be processed.");
            }
            if (paymentMethod == null || paymentMethod.isEmpty()) {
                throw new IllegalArgumentException("Invalid payment method. Payment cannot be processed.");
            }
            if (walletId == null || walletId.isEmpty()) {
                throw new IllegalArgumentException("Wallet ID is required for payment processing.");
            }

            System.out.println("Processing payment of " + amount + " using " + paymentMethod + " with wallet ID: " + walletId + ".");
            System.out.println("Payment processed successfully.");
            // return confirmPayment(generateTransactionId());
        } catch (IllegalArgumentException  e) {
            System.out.println("Error: " + e.getMessage());           
        }
    }

    @Override
    public String generateTransactionId() {
        return "Paytm-" + System.nanoTime();
    }

    @Override
    public String confirmPayment(String transactionId) {
        if (transactionId == null || transactionId.isEmpty()) {
            System.out.println("Invalid transaction ID.");
            return null;
        }
        System.out.println("✅ " + paymentMethod + " payment confirmed.");
        return transactionId;
    }
}
