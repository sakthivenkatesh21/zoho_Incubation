package Day3;
interface Notification{
    String sendNotification();
}
class Paytm implements Notification{
    public String sendNotification(){
        return "Payment done using Paytm";
    }
}
class Gpay implements Notification{
    public String sendNotification(){
        return "Payement done from Gpay";
    }
}
class SlicePay implements Notification{
    public String sendNotification(){
        return "Slice Bill Generated";
    }
}
class Notifications{
    public void sendNotification(Notification notification){
        System.out.println(notification.sendNotification());
    }
}

public class InterfaceNotification {
    public static void main(String[] args) {
        Notification paytm = new Paytm();
        Notification gpay  = new Gpay();
        
        Notifications notification = new Notifications();
        notification.sendNotification(gpay);
        notification.sendNotification(paytm);

        Notification slice = new SlicePay();
        notification.sendNotification(slice);
    }
}
