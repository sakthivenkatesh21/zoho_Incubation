package zohoincubation.com.zoho.ecommerce.src.view;

public interface IPaymentGateway {
    
    void processPayment();
    String generateTransactionId();
    String confirmPayment(String transactionId);
}
