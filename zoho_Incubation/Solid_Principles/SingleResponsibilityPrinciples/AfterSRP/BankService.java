package zoho_Incubation.Solid_Principles.SingleResponsibilityPrinciples.AfterSRP ;

public class BankService {
    String name ;
    String accNo;
    double balance;
    

    public void openAccount(String name,String accNo,double balance){

        this.name = name;
        this.accNo = accNo;
        if(balance>0){
            this.balance = balance;
            System.out.println("Account Create Success");
            System.out.println("Name :"+name+"\nAccNo :"+accNo+"\nBalance :"+balance);
        }
        else{
            System.out.println("Account Created Failed");
        }
    }

}
