package zohoincubation.solidprinciples.liskovsubstitutionprinciple.AfterLSP;

public class Cycle extends InterfaceVechicle{
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
