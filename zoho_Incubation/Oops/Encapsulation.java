class StateBank{
    private String name ;
    private String accNo;
    private  double balance;
    StateBank(String name,String accNo,double balance){
        this.name=name;
        this.accNo=accNo;
        this.balance=balance> 0 ? balance : 0;
    }

    public double getBalance() {
        return balance;
    }
    public void deposite(double balance) {
        if(balance>0){
            this.balance = balance;
            System.out.println("Amount Credited "+balance);
        }
        else
            System.out.println("Amount should be Postive");    
    }
    public void withdraw(double amount){
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Remaining Balance: " + balance);
        } else {
            System.out.println("Invalid withdraw amount or Insufficient balance.");
        }
    }
    public String getAccNo() {
        return accNo;
    }
    public void setAccNo(String accNo) {

        this.accNo = accNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        StateBank stateBank = new StateBank("StateBank","12345",100.0);

        System.out.println("Name :"+stateBank.getName());
        System.out.println("Account Number :"+stateBank.getAccNo());
        System.out.println("Balance "+stateBank.getBalance());
        stateBank.deposite(1000);
        stateBank.withdraw(0);


    }
}
