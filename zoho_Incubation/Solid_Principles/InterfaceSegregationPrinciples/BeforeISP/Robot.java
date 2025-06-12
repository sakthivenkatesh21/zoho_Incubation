package zoho_Incubation.Solid_Principles.InterfaceSegregationPrinciples.BeforeISP;

public class Robot implements Workers{
    private String name;
    private String version;
    public Robot(String name, String version) {
         this.name = name;
         this.version = version;
    }
    @Override
    public void eat(String food) {
         throw new UnsupportedOperationException("Robot Can't Eat");
         
    }
    @Override
    public void sleep(int time) {
         throw new UnsupportedOperationException("Robot Can't Sleep");
         
    }
    @Override
    public void work(String work) {
         System.out.println("Name :"+name+" Version :"+version+"\n Working as a "+work);
    }
}