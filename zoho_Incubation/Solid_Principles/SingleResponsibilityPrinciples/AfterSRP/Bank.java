package zoho_Incubation.Solid_Principles.SingleResponsibilityPrinciples.AfterSRP ;

public class Bank {
    public static void main(String[] args) {
        
        BankService service = new BankService();
        service.openAccount("Sakthi","98308273633", 1000);

        NotificationService notificationService = new NotificationService();
        notificationService.emailNotification(service);
        
        TransactionService transactionService = new TransactionService();
        transactionService.deposite(service, 2000);
        transactionService.withdraw(service, 200);

    }
}
