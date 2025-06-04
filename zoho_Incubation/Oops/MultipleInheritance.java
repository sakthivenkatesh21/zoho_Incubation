
interface  Camera{
    void camera();
    
}
interface PhoneManager {
    void call();
    
}
interface  Music{
    void playMusic();
}
class Phone implements Camera, PhoneManager,Music{
    public void call(){
        System.out.println("PhoneManeger used for calling");
    }
    public void camera(){
        System.out.println("Camera have 48 Mb Sensor ");
    }
    public void playMusic(){
        System.out.println("Spotity music are playing");
    }
}
public class MultipleInheritance {
    public static void main(String[] args) {
        Phone objPhone = new Phone();
        objPhone.call();
        objPhone.camera();
        objPhone.playMusic();
    }
}
