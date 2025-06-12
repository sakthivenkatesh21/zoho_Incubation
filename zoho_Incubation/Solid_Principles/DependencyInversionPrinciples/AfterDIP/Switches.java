package zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.AfterDIP;

public class Switches {

    private Remote button;

    public Switches(Remote button){
        this.button = button;
    }
    public void ON(){
        button.turnOn();  
    }
    public void OFF(){
        button.turnoff();
    }
}
