package Day3;
class  Camera{
    String camera(int number ){
        return number == 1 ? "Camere is Turn on": "Camera is TurnOFF";         
    }   
}
interface PhoneManager {
    void call(String number);
    String camera(int number);    
}
interface  Music{
    void playMusic(String [] music);
}

class Phone extends Camera  implements  PhoneManager,Music{
    private String brand;
    private String model;
    private int batteryPercentage;

    public Phone(String brand, String model, int batteryPercentage) {
        this.brand = brand;
        this.model = model;
        this.batteryPercentage = batteryPercentage;
    }

    public void call(String number){
        if(number.length()==10)
            System.out.println("PhoneManeger used for calling");
        else
            System.out.println("Incorrect Phone Number");    
    }

    public String camera(int mode){
        return mode == 1 ?  "RearCamera have 48 Mb Sensor " :  "FrontCamera have 32 Mb Sensor"  ;
    }

    public void playMusic(String [] musics){
        System.out.println("Spotity music are playing");
        for(String music : musics)
            System.out.println(music);
    }
    public void showPhoneInfo() {
        System.out.println("\n  Phone Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Battery: " + batteryPercentage + "%");
    }

}
public class MultipleInheritance {
    public static void main(String[] args) {
        Phone objPhone = new Phone("Poco","X4 Pro 5g",20);
        objPhone.showPhoneInfo();
        objPhone.call("9025149405");
        objPhone.camera(1);
        objPhone.playMusic(new String[] {"BGM","No more Ring ","Find a days"});
    }
}
