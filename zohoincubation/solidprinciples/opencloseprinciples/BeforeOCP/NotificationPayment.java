package zohoincubation.solidprinciples.opencloseprinciples.BeforeOCP;

public class NotificationPayment{
    private String name ;
    private String accNo;
    private String paymentMode;
    private double balance;
    
    public NotificationPayment(String paymentMode, String accNo, String name, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.paymentMode = paymentMode;
        this.balance = balance;
    }

    public void paymentProccessor(){
        if(balance>0){
            if(paymentMode.equalsIgnoreCase("UPI")){
                System.out.println("Name :"+name+" AccNo : "+accNo+" Via Mode : "+paymentMode+" $"+ balance+" USING UPI Payment Done Success" );
            }
            else if(paymentMode.equalsIgnoreCase("Card")){
                System.out.println("Name :"+name+" AccNo : "+accNo+" Via Mode : "+paymentMode+" $"+ balance+" USING Card Payment Done Success" );
            }
        }
        else{
            System.out.println("Payment Invalid! ");
        }
    }

}
