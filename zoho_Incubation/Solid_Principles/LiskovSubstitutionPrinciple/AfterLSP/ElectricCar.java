package zoho_Incubation.Solid_Principles.LiskovSubstitutionPrinciple.AfterLSP;

public class ElectricCar implements Charge {
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
