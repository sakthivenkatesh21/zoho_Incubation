package zohoincubation.solidprinciples.opencloseprinciples.AfterOCP;

public class Notification {

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        
        PaymentProcessing upi  = new UPI("90232293839@sbi");
        PaymentProcessing card = new Card("938387473902398383", "MJSY");
        
        processor.pay(card, "Mukil", 1000);
        processor.pay(upi, "Guru", 2000);

    }
}