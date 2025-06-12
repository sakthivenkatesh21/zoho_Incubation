package zoho_Incubation.Solid_Principles.OpenClosePrinciples.AfterOCP;

class UPI implements PaymentProcessing{
    private String upiId;

    UPI(String upiId){
        this.upiId    = upiId;
    }
    public void pay(String custName, double balance){
        if(balance<0){
            System.out.println("Payment Invalid !");
            return;
        }
        System.out.println("\n"+custName + " paid ₹" + balance + " using UPI (" + upiId + ").\n");
    }
}

