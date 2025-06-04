
abstract class Person{
    String name;
    Person(String name){
        this.name = name;
    }
    void eat(){
        System.out.println(name +" Eating...");
    }
    void sleep(){
        System.out.println(name+" Sleeping...");
    }
    abstract void talk();
    abstract void walk();
    abstract void study();
    abstract void aim();
}
abstract  class Child extends Person{
    Child(String name){
        super(name);
    }
    public void talk(){
        System.out.println(name+" Talking...");
    }
    public void walk(){
        System.out.println(name+" Walking...");
    }
}
abstract class Adult extends Child{
    Adult(String name){
        super(name);
    }
    void  study(){
        System.out.println(name+" is Studing...");
    }
}
class Teenage extends Adult{
    Teenage(String name){
        super(name);
    }
    public void aim(){
        System.out.println(name+"Got Work Sucessfully!");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Person teenage = new Teenage("Karthick");
        teenage.eat();
        teenage.sleep();
        teenage.walk();
        teenage.talk();
        teenage.study();
        teenage.aim();
    }
}
