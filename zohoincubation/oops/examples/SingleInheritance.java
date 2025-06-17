package zohoincubation.oops.examples;
//class Bluetooth{
//    void connectblueTooth(){
//        System.out.println("Bluetooth Connected");
//    }
//}
class Buds {
    void connectblueTooth(){
        System.out.println(" Buds Bluetooth Connected");
    }
}
class Boat extends Buds{
    void connectblueTooth(){
        System.out.println(" Boat Bluetooth Connected");
    }
}
class Realme extends Buds{
    void connectblueTooth(){
        System.out.println(" Realme Bluetooth Connected");
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        Buds boat = new Boat();
        connectblueTooth(boat);
        Buds realme = new Realme();
        connectblueTooth(realme);
    }
    private  static void connectblueTooth(Buds buds) {
        buds.connectblueTooth();
    }
}
