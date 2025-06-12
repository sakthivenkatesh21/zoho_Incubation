package zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.BeforeDIP;

import zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.AfterDIP.Remote;

public class SwitchDevice{

    private Bulb bulb; // here SwitchDevice class  is depending on  bulb if we want to fan
                      // then need to modify the current class  
    public SwitchDevice(Bulb bulb) {
        this.bulb  = bulb;
    }
    public void switchOperation(){
        bulb.turnOn();
        bulb.turnoff();
    }
    public void accessSwitch(Remote fan) {
        throw new UnsupportedOperationException("Unimplemented method 'accessSwitch'");
    }
}

