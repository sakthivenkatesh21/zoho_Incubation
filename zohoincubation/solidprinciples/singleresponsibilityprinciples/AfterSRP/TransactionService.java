package zohoincubation.solidprinciples.singleresponsibilityprinciples.AfterSRP ;

public class TransactionService {

    public void withdraw(BankService account,double balance){
        if(account.balance>=balance && balance >0){
            account.balance -=balance; 
            System.out.println("Name :"+account.name+"\nAccNo :"+account.accNo+"\nCurrentBalance :"+account.balance);
            System.out.println("Amount Withhdraw : "+balance);
        }
        else    
            System.out.println("Invalid Amount");
    }

    public void deposite(BankService account,double balance){
        if(balance>0){
            account.balance += balance;
            System.out.println("Name :"+account.name+"\nAccNo :"+account.accNo+"\nBalance :"+account.balance);

        }
        else{
            account.balance = 0;
        }
    }
}
