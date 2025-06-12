package zoho_Incubation.Solid_Principles.LiskovSubstitutionPrinciple.AfterLSP;

public class Car implements Fuel{
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
