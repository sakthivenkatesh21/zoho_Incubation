package zohoincubation.solidprinciples.dependencyinversionprinciples.AfterDIP;

public class Main {
    public static void main(String[] args) {

        Switch bulb = new Bulb("LED", "Panasonic");
        Switch fan = new Fan("Mini-Fan","V-Guard",120);
        
        Button button1 = new Button(bulb);
        Button button2 = new Button(fan);

        button1.ON();
        button1.OFF();

        button2.ON();
        button2.OFF();
    }
}