package zohoincubation.oops.modified;
class Plane {
    String brand;
    int capacity;

    Plane(String brand, int capacity) {
        this.brand = brand;
        this.capacity = capacity;
    }

    void fly() {
        System.out.println(brand + " plane is flying with capacity of " + capacity + " members.");
    }

    void planeInfo() {
        System.out.println("Brand: " + brand + ", Capacity: " + capacity);
        System.out.println();
    }
}

class CargoPlane extends Plane {
    double maxLoad;

    CargoPlane(String brand, int capacity, double maxLoad) {
        super(brand, capacity);
        this.maxLoad = maxLoad;
    }

    void carry() {
        System.out.println("Cargo Plane carries goods up to " + maxLoad + " tons.");
    }

    void loadCargo() {
        System.out.println("Loading heavy cargo into CargoPlane...");
    }
}

class PassengerPlane extends Plane {
    int seatCount;

    PassengerPlane(String brand, int capacity, int seatCount) {
        super(brand, capacity);
        this.seatCount = seatCount;
    }

    void carry() {
        System.out.println("Passenger Plane carries " + seatCount + " passengers.");
    }

    void serveFood() {
        System.out.println("Serving meals to passengers...");
    }
}

class FighterPlane extends Plane {
    int missiles;

    FighterPlane(String brand, int capacity, int missiles) {
        super(brand, capacity);
        this.missiles = missiles;
    }

    void carry() {
        System.out.println(" Fighter Plane carries " + missiles + " missiles.");
    }

    void attackMode() {
        System.out.println(" Fighter Plane is in attack mode!");
    }
}

public class HierarichalInheritance {
    public static void main(String[] args) {

        CargoPlane cargo = new CargoPlane("Indica", 5, 20);
        cargo.planeInfo();
        cargo.fly();
        cargo.carry();
        cargo.loadCargo();

        System.out.println();

        PassengerPlane passenger = new PassengerPlane("AirIndia", 180, 160);
        passenger.planeInfo();
        passenger.fly();
        passenger.carry();
        passenger.serveFood();

        System.out.println();

        FighterPlane fighter = new FighterPlane("Vikram2", 2, 6);
        fighter.planeInfo();
        fighter.fly();
        fighter.carry();
        fighter.attackMode();
    }
}
