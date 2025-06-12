package zoho_Incubation.Solid_Principles.SingleResponsibilityPrinciples.BeforeSRP;

class Bank {
    private String accNo;
    private String name;
    private double balance;

    
    public Bank(String accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public void openAccount(){
        if(balance>0){
            System.out.println("Account Created Sucess \n Name: "+name+"\n AccNo : "+accNo+"\n Balance :"+balance);
        }
        else{
            System.out.println("Invalid Balance");
        }
    }

    public void sendMail(String from,String to, String msg){
        System.out.println("From :"+from+"\n To :"+to+"\n Msg : "+msg+" \n");
    }
    
     public void withdraw(double balance){
        if(this.balance>=balance && balance >0){
            this.balance -=balance; 
            System.out.println("Name :"+this.name+"\nAccNo :"+this.accNo+"\nCurrentBalance :"+this.balance);
            System.out.println("Amount Withhdraw : "+balance);
        }
        else    
            System.out.println("Invalid Amount");
    }

    public void deposite(double balance){
        if(balance>0){
            this.balance += balance;
            System.out.println("Name :"+this.name+"\nAccNo :"+this.accNo+"\nCredited Balance :"+this.balance);

        }
        else{
            System.out.println("Invalid Amount");
        }
    }
}


