package zohoincubation.solidprinciples.interfacesegregationprinciples.BeforeISP;

public class Human implements Workers{
    private String name ;
    private int    age  ;
    
    public Human(String name, int age) {
         this.name = name;
         this.age = age;
    }

    public void eat(String food) {
         System.out.println(name+" was Eating "+food);
    }
    public void sleep(int time) {
         System.out.println(name+" Working "+time+" hrs");
    }
    public void work(String work) {
         System.out.println("Name :"+name+" Age :"+age+"\n Working as a "+work);
    } 
}
