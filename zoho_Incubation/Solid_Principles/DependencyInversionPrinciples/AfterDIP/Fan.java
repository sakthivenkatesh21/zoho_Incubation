package zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.AfterDIP;

public class Fan implements Remote{
    private String deviceName;
    private String brand;
    private int volts ;
    private boolean turn = false;

    Fan(String deviceName, String brand,int volts){
        this.deviceName = deviceName;
        this.brand  = brand;
        this.volts = volts;
    }

    public void turnOn(){
        if(!turn){
            System.out.println(brand+" "+deviceName+ " is running under volts "+volts+"Turn ON");
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
