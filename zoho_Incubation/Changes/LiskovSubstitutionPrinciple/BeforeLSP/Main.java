package zoho_Incubation.Changes.LiskovSubstitutionPrinciple.BeforeLSP;

public class Main {
    public static void main(String[] args) {
        
        Vechile fCar = new Car("Fortuner");
        System.out.println(fCar.getBrand());
        fCar.fuel();
        fCar.start();
        fCar.stop();
        Vechile eCar = new ElectricCar("TATA");
        System.out.println(eCar.getBrand());
        eCar.start();
        eCar.stop();
        eCar.fuel();

        
    }
}
