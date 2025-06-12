package zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.BeforeDIP;

public class Bulb{
    private String deviceName;
    private String brand;
    private boolean turn = false;

    Bulb(String deviceName, String brand){
        this.deviceName = deviceName;
        this.brand  = brand;
    }
    public void turnOn(){
        if(!turn){
            System.out.println(brand+" "+deviceName+ " is "+"Turn ON");
            turn = true;
        }
        else
            System.out.println(deviceName+" Already ON ");
    }
    public void turnoff(){
        if(turn){
            System.out.println(brand+" "+deviceName+ " is "+"Turn OFF");
            turn = false;
        }
        else
            System.out.println(deviceName+" Already OFF ");
    }
}

