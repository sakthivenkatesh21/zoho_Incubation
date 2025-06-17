package zohoincubation.solidprinciples.dependencyinversionprinciples.BeforeDIP;


public class Switch {
    public static void main(String[] args) {

        Bulb bulb = new Bulb("LED", "Panasonic");

        Button button = new Button(bulb);
        button.switchOperation();
    }
}
