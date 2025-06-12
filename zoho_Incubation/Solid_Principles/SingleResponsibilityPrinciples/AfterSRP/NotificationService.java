package zoho_Incubation.Solid_Principles.SingleResponsibilityPrinciples.AfterSRP ;

public class NotificationService {
    public void emailNotification(BankService bankService){
        if(bankService instanceof BankService)
            System.out.println("Name :"+ bankService.name+"AccNo :"+bankService.accNo+" \n Notification send to mail");
    }
}
