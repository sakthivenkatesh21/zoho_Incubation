package zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.AfterDIP;

public class Main {
    public static void main(String[] args) {

        Remote bulb = new LightBulb("LED", "Panasonic");
        Remote fan = new Fan("Mini-Fan","V-Guard",120);
        
        Switches button1 = new Switches(bulb);
        Switches button2 = new Switches(fan);

        button1.ON();
        button1.OFF();

        button2.ON();
        button2.OFF();
    }
}