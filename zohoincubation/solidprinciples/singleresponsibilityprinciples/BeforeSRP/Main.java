package zohoincubation.solidprinciples.singleresponsibilityprinciples.BeforeSRP;

public class Main{
    public static void main(String[] args) {
        Bank bank = new Bank("937363673636728", "Sakthi", 3000);
        bank.openAccount();
        bank.sendMail("kishore@mail", "sakthi@mail.com", "Welcome to the Hasy Bank");
        bank.deposite(1000);
        bank.withdraw(200);
    }
}
