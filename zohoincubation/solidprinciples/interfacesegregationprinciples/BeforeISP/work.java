package zohoincubation.solidprinciples.interfacesegregationprinciples.BeforeISP;

public class work {

     public static void main(String[] args) {
        Workers human = new Human("Mani", 22);
        Workers robo = new Robot("Yitc", "3.0");

          human.eat("Dosa");
          human.sleep(9);
          human.work("Driving");
          
          robo.work("Cooking");
          robo.eat("Meals");
          robo.sleep(3);
          

     }
}