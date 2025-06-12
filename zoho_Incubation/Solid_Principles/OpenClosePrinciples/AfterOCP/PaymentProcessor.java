package zoho_Incubation.Solid_Principles.OpenClosePrinciples.AfterOCP;

class PaymentProcessor{
    public void pay(PaymentProcessing method, String custName, double balance){
        method.pay(custName, balance);
    }
}
