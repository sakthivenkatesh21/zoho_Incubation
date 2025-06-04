class Devices{
    String status ;
    String powerOn(String curr){
        status =  curr.equalsIgnoreCase("ON") ?
        "Device Powered on" :curr.equalsIgnoreCase("OFF")? "Shudown" : "Invalid Error";
        return status;
    }
}
class Laptop extends Devices{
    void study(){
        if(status.equalsIgnoreCase("Device Powered on"))
            System.out.println("Laptop is Switched ON to study");
        else if(status.equalsIgnoreCase("Shudown"))
            System.out.println("Please Switch ON the laptop");
        else 
            System.out.println("Error Found"+status);    
    }
}
class GamingLaptop extends  Laptop{
    void gaming(String processor){
        if(processor.equalsIgnoreCase("i7") || processor.equalsIgnoreCase("intel 11"))
            System.out.println("Gaming support Laptop ");
        else 
            System.out.println("Normal usage Non-Gaming Laptop");    
    }
}
public class MultilevelInheritance {
    public static void main(String[] args) {
        GamingLaptop gaming = new GamingLaptop();
        System.out.println(gaming.powerOn("Off"));
        gaming.study();
        gaming.gaming("Snapdragon");
    }
}
