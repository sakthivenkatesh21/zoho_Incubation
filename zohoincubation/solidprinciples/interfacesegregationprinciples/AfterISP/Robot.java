package zohoincubation.solidprinciples.interfacesegregationprinciples.AfterISP;

public class Robot implements Workers{
    private String name;
    private String version;
    public Robot(String name, String version) {
         this.name = name;
         this.version = version;
    }
    public void work(String work) {
         System.out.println("Name :"+name+" Version :"+version+"\n Working as a "+work);
    }
}
