package zohoincubation.oops.examples;
interface Bottle {
    default  void openBottle(){
        System.out.println(" Bottle opened");
    }
    default void closeBottle(){
        System.out.println("Water Bottle closed");
    }
    void storesBottle();
}
class WaterBottle implements Bottle {
    public void storesBottle() {
        System.out.println("It Stores Water in inside the bottle");
    }
}
class Flask implements Bottle {
    public void storesBottle() {
        System.out.println("It Stores Hot Liquid in inside the bottle");
    }
}
public class InterfaceAbtraction {
    public static void main(String[] args) {
        Bottle waterbottle = new WaterBottle();
        Bottle flaskbottle = new Flask();
        test(waterbottle);
        test(flaskbottle);

    }
    private  static  void test(Bottle bottle) {
        bottle.openBottle();
        bottle.storesBottle();
        bottle.closeBottle();
    }
}