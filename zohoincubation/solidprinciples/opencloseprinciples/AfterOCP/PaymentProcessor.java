package zohoincubation.solidprinciples.opencloseprinciples.AfterOCP;

class PaymentProcessor{
    public void pay(PaymentProcessing method, String custName, double balance){
        method.pay(custName, balance);
    }
}
