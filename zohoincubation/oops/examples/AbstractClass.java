package zohoincubation.oops.examples;

abstract class Person{
    String name;
    int energy = 0;
    Person(String name){
        this.name = name;
    }
    void eat(String food){
        energy +=20;
        System.out.println(name +" Eating "+food+" Energy Increaces "+energy);
    }
    void sleep(int  sleepTime){
        energy+=(sleepTime*10)/2;
        System.out.println(name+" Sleeping .."+sleepTime+"hrs Energy is "+energy);
    }
    abstract void talk(String topic);
    abstract void walk(int km);
    abstract void study(String subject);
    abstract void aim(String aim);
}
abstract  class Child extends Person{
    Child(String name){
        super(name);
    }
    public void talk(String topic){
        System.out.println(name+" Talking about "+topic);
    }
    public void walk(int km){
        if(km>0)
         energy -=km/10;
        System.out.println(name+" is Walking "+km+"KM Energy is "+energy);
    }
}
abstract class Adult extends Child{
    Adult(String name){
        super(name);
    }
    void  study(String subject){
        energy -=20;
        System.out.println(name+" is Studing "+subject+" Energy decreases "+energy);
    }
}
class Teenage extends Adult{
    Teenage(String name){
        super(name);
    }
    public void aim(String aim){
        System.out.println(name+" achived Aim that  "+aim);
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Person teenage = new Teenage("Karthick");
        teenage.eat("Dosa");
        teenage.sleep(10);
        teenage.walk(12);
        teenage.talk("Weathers");
        teenage.study("CS");
        teenage.aim("IT");
    }
}
