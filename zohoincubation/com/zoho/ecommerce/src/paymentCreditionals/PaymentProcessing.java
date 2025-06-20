package zohoincubation.com.zoho.ecommerce.src.paymentCreditionals;

public class PaymentProcessing {
    private IPaymentGateway iPaymentGateway;

    public PaymentProcessing(IPaymentGateway iPaymentGateway) {
        this.iPaymentGateway = iPaymentGateway;
    }

    public IPaymentGateway getIPaymentGateway() {
        return iPaymentGateway;
    }

    public String processPayment() {
        iPaymentGateway.processPayment();
        return iPaymentGateway.confirmPayment(
            iPaymentGateway.generateTransactionId()
        );
    }
}
