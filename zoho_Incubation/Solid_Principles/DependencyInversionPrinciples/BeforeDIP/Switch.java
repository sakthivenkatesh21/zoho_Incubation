package zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.BeforeDIP;


public class Switch {
    public static void main(String[] args) {

        Bulb bulb = new Bulb("LED", "Panasonic");

        SwitchDevice sDevice = new SwitchDevice(bulb);
        sDevice.switchOperation();
    }
}
