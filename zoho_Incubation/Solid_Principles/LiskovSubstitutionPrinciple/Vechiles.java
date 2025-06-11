package zoho_Incubation.Solid_Principles.LiskovSubstitutionPrinciple;
interface Vechile {
    String getBrand();
    void stop();
    void start();
}
interface Fuel extends Vechile{
    void fuel();
}
interface Electric extends Vechile{

    void charge ();
}

class ElectricCar implements Electric{
    private String brand;
    private int batteryLevel;

    
    public ElectricCar(String brand) {
        this.brand = brand;
        this.batteryLevel = 0;
    }

    public String getBrand(){
        return brand;
    }
    public void start() {
        System.out.println(brand + " electric car started.");
    }

    public void stop() {
        System.out.println(brand + " electric car stopped.");
    }
    public void charge() {
        batteryLevel = 100;
        System.out.println(brand + " battery charged to "+batteryLevel+"%.");
    }
}
class Car implements Fuel{
    private String brand;
    private int fuelLevel;

    Car(String brand){
        this.brand = brand;
        this.fuelLevel =0;
    }
    public String getBrand(){
        return brand;
    }
    public void start() {
        System.out.println(brand + " petrol car started.");
    }

    public void stop() {
        System.out.println(brand + " petrol car stopped.");
    }

    public void fuel() {
        fuelLevel = 100;
        System.out.println(brand + " refueled to "+fuelLevel+"%.");
    }
}
class Cycle implements Vechile{
    private String brand;

    public Cycle(String brand) {
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }
    public void start() {
        System.out.println(brand + "  Cycle started.");
    }

    public void stop() {
        System.out.println(brand + " Cycle stopped.");
    }
}

public class Vechiles {
    public static void main(String[] args) {
        Electric eCar = new ElectricCar("TATA");
        System.out.println(eCar.getBrand());
        eCar.charge();;
        eCar.start();
        eCar.stop();

        Fuel fCar = new Car("Fortuner");
        System.out.println(fCar.getBrand());
        fCar.fuel();
        fCar.start();
        fCar.stop();

        Vechile cyle = new Cycle("Hercules");
        System.out.println(cyle.getBrand());
        cyle.start();
        cyle.stop();
        
    }
}
