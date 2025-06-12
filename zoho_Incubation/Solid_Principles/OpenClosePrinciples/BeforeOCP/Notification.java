package zoho_Incubation.Solid_Principles.OpenClosePrinciples.BeforeOCP;



public class Notification {
    public static void main(String[] args) {
        NotificationPayment upiPayment = new NotificationPayment("UPI", "8474848448939993", "Kirs", 3000);
        upiPayment.paymentProccessor();

        NotificationPayment cardPayment = new NotificationPayment("Card", "7464643738873783", "Krishna", 9000);
        cardPayment.paymentProccessor();
    }
}
