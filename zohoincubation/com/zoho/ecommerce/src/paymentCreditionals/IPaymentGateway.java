package zohoincubation.com.zoho.ecommerce.src.paymentCreditionals;

public interface IPaymentGateway {

    String processPayment();

    String generateTransactionId();

    String confirmPayment(String transactionId);
}
