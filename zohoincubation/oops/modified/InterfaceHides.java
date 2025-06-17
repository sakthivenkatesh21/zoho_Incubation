package zohoincubation.oops.modified;

public class InterfaceHides {
    public static void main(String[] args) {
        // PayementService service = PaymentProvider.getPayementService();
        // service.pay(1000,"1233222","sakthi");
    }
}
























// interface PayementService{
//     void pay(double amount,String accNo, String name);
// }
// class Paytm implements PayementService{
//     private double amount;
//     private String accNo;
//     private String name;
//     public void pay(double amount,String accNo, String name){
//         System.out.println("Account No : "+accNo+"\n Name : "+name+"\n Amount : "+amount+"\n "+" Payment Done by Paytm");
//     }
// }
// class PaymentProvider{
//     public static PayementService getPayementService(){
//         return new Paytm();
//     }
// }