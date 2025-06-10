package Day3;
class Buds {
    String brand;
    String model;

    Buds(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
 
    void connectblueTooth() {
        System.out.println(brand + " " + model + " Bluetooth Connected");
    }
}

class Boat extends Buds {
    String version;

    Boat(String brand, String model, String version) {
        super(brand, model);
        this.version = version;
    }
    void connectblueTooth() {
        System.out.println(brand + " " + model + " Boat Bluetooth v" + version + " Connected");
    }
}

class Realme extends Buds {
    String version;

    Realme(String brand, String model, String version) {
        super(brand, model);
        this.version = version;
    }
    void connectblueTooth() {
        System.out.println(brand + " " + model + " Realme Bluetooth v" + version + " Connected");
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        Buds boat = new Boat("Boat", "Airdopes 161", "5.3");
        connectblueTooth(boat);

        Buds realme = new Realme("Realme", "Buds Q2", "5.2");
        connectblueTooth(realme);
    }

    private static void connectblueTooth(Buds buds) {
        buds.connectblueTooth();  
    }
}

