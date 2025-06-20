package zohoincubation.com.zoho.ecommerce.src.internal;

import zohoincubation.com.zoho.ecommerce.src.paymentCreditionals.IPaymentGateway;

public class Gpay implements IPaymentGateway {
    private double amount;
    private String paymentMethod;
    private String creditionals;

    public Gpay(double amount, String paymentMethod, String creditionals) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.creditionals = creditionals;
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
            if (creditionals == null || creditionals.isEmpty()) {
                throw new IllegalArgumentException("Card details are required for payment processing.");
            }

            System.out.println("Processing payment of " + amount + " using " + paymentMethod + ".");
            System.out.println("Payment processed successfully.");
            Thread.sleep(2000);

        } catch (IllegalArgumentException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                System.out.println("Payment process was interrupted. Please try again.");
            } else {
                System.out.println("Error: " + e.getMessage());
            }
            return;
        }
    }

    @Override
    public String generateTransactionId() {
        return "GPay-" + System.nanoTime();
    }

    @Override
    public String confirmPayment(String transactionId) {
        if (transactionId == null || transactionId.isEmpty()) {
            System.out.println("Invalid transaction ID.");
            return null;
        }

        return "✅" + paymentMethod + " confirmed. Transaction ID: " + transactionId;
    }
}
