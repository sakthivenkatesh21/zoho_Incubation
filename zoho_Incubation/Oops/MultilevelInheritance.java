class Devices{
    void powerOn(){
        System.out.println("Powering on");
    }
}
class Laptop extends Devices{
    void study(){
        System.out.println("Laptop is used to study");
    }
}
class GamingLaptop extends  Laptop{
    void gaming(){
        System.out.println("Gaming support Laptop ");
    }
}
public class MultilevelInheritance {
    public static void main(String[] args) {
        GamingLaptop gaming = new GamingLaptop();
        gaming.powerOn();
        gaming.study();
        gaming.gaming();
    }
}
