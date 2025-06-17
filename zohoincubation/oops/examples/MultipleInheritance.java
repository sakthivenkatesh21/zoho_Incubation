package zohoincubation.oops.examples;

interface  Camera{
    String camera(int number );
    
}
interface PhoneManager {
    void call(String number);
    
}
interface  Music{
    void playMusic(String [] music);
}
class Phone implements Camera, PhoneManager,Music{
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
}
public class MultipleInheritance {
    public static void main(String[] args) {
        Phone objPhone = new Phone();
        objPhone.call("9025149405");
        objPhone.camera(1);
        objPhone.playMusic(new String[] {"BGM","No more Ring ","Find a days"});
    }
}
