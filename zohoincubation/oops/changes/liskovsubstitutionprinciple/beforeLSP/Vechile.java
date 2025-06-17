package zohoincubation.oops.changes.liskovsubstitutionprinciple.beforeLSP;

public  class  Vechile {
    public  String getBrand(){
        return "Vechile";
    }
    public void start() {
        System.out.println("Vehicle Start");
    }

    public void stop() {
        System.out.println(" Vehicle  stopped.");
    }
    public void fuel(){
        System.out.println("Fuel ");
    }
}
