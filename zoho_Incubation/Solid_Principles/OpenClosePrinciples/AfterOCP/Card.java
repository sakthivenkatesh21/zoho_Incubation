package zoho_Incubation.Solid_Principles.OpenClosePrinciples.AfterOCP;

class Card implements PaymentProcessing{
    private String cardNo;
    private String bankName;

    Card(String cardNo, String bankName) {
        this.cardNo = cardNo;
        this.bankName = bankName;
    }

    public void pay(String custName, double balance){
        if(balance>0)
            System.out.println("\n"+custName + " paid ₹" + balance + " using Card (" + bankName + " - " + cardNo + ").\n");
        else
            System.out.println("Payment Failed");    
    }
}
