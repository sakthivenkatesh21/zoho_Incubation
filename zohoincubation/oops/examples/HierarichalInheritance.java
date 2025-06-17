package zohoincubation.oops.examples;
class Plane{
    void fly() {
        System.out.println("Plane flying");
    }
}
class CargoPlane extends Plane{
    void carry(){
        System.out.println(" Cargo plane carry Goods");
    }
}
class PassengerPlane extends Plane{
    void carry(){
        System.out.println(" Passenger plane carry Peoples");
    }
}
class FighterPlane extends Plane{
    void carry(){
        System.out.println(" Fighter plane carry Weapons");
    }
}
public class HierarichalInheritance {
    public static void main(String[] args) {
        CargoPlane cplane = new CargoPlane();
        cplane.fly();
        cplane.carry();
        PassengerPlane pplane = new PassengerPlane();
        pplane.fly();
        pplane.carry();
        FighterPlane fplane = new FighterPlane();
        fplane.fly();
        fplane.carry();
    }
}
