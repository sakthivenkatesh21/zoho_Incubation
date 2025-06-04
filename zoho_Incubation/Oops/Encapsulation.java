class StateBank{
    private String name ;
    private String accNo;
    private  double balance;
    StateBank(String name,String accNo,double balance){
        this.name=name;
        this.accNo=accNo;
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if(balance>0)
            this.balance = balance;
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
        System.out.println(stateBank.getName());
        System.out.println(stateBank.getAccNo());
        System.out.println(stateBank.getBalance());
        System.out.println(stateBank.getAccNo());

    }
}
