package zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.BeforeDIP;

public class Button{

    private Bulb bulb; // here SwitchDevice class  is depending on  bulb if we want to fan
                      // then need to modify the current class  
    public Button(Bulb bulb) {
        this.bulb  = bulb;
    }
    public void switchOperation(){
        bulb.turnOn();
        bulb.turnoff();
    }
    
}

