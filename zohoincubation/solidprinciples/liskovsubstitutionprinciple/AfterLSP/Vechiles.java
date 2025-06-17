package zohoincubation.solidprinciples.liskovsubstitutionprinciple.AfterLSP;

public class Vechiles {
    public static void main(String[] args) {
        Charge eCar = new ElectricCar("TATA");
        System.out.println(eCar.getBrand());
        eCar.charge();
        eCar.start();
        eCar.stop();

        Fuel fCar = new Car("Fortuner");
        System.out.println(fCar.getBrand());
        fCar.fuel();
        fCar.start();
        fCar.stop();

        InterfaceVechicle cyle = new Cycle("Hercules");
        System.out.println(cyle.getBrand());
        cyle.start();
        cyle.stop();
        
    }
}
