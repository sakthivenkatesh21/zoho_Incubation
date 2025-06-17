package zohoincubation.solidprinciples.interfacesegregationprinciples.AfterISP;


public class work {

     public static void main(String[] args) {
        Human man = new Human("Mani", 22);
        Workers robo = new Robot("Yitc", "3.0");

          man.eat("Dosa");
          man.sleep(9);
          man.work("Driving");

          robo.work("Cooking");

     }
}