package zoho_Incubation.Solid_Principles.DependencyInversionPrinciples.AfterDIP;

public class Button {

    private Switch button;

    public Button(Switch button){
        this.button = button;
    }
    
    public void ON(){
        button.turnOn();  
    }
    public void OFF(){
        button.turnoff();
    }
}
