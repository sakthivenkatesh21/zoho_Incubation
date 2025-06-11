package zoho_Incubation.Solid_Principles.OpenClosePrinciples;

interface PaymentProcessing {
    void pay(String custName,double balance );
}

class Upi implements PaymentProcessing{
    private String UpiId;

    Upi(String UpiId){
        this.UpiId    = UpiId;
    }
    public void pay(String custName, double balance){
        System.out.println("\n"+custName + " paid ₹" + balance + " using UPI (" + UpiId + ").\n");
    }
}

class Card implements PaymentProcessing{
    private String cardNo;
    private String bankName;

    Card(String cardNo, String bankName) {
        this.cardNo = cardNo;
        this.bankName = bankName;
    }

    public void pay(String custName, double balance){
        System.out.println("\n"+custName + " paid ₹" + balance + " using Card (" + bankName + " - " + cardNo + ").\n");
    }
}

class PaymentProcessor{
    public void pay(PaymentProcessing method, String custName, double balance){
        method.pay(custName, balance);
    }
}

public class Notification {

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        
        PaymentProcessing upi  = new Upi("90232293839@sbi");
        PaymentProcessing card = new Card("938387473902398383", "MJSY");
        
        processor.pay(card, "Mukil", 1000);
        processor.pay(upi, "Guru", 2000);

    }
}