package Day3;
import java.util.*;

class Employee{
    String name ;
    int rollNo;
    double salary;
    public Employee(String name, int rollNo, double salary) {
        this.name = name;
        this.rollNo = rollNo;
        this.salary = salary;
    }
    public void info(){
        System.out.println("Employee Name"+ name+" Roll No :"+rollNo+" Salary :"+ salary);
    }  
}
class Cashier extends Employee{
    Cashier(String name , int rollNo, double salary){
        super(name, rollNo, salary);
    }
    public void role(){
        System.out.println("I am Cashier "+salary+" is my Salary");
    }
    
}
class Doctor extends Employee{
    String specialist;

    public Doctor(String name, int rollNo, double salary, String specialist) {
        super(name, rollNo, salary);
        this.specialist = specialist;
    }
    public void role(){
        System.out.println("I am Doctor "+salary+" is my Salary"+" I Specialist in "+specialist);
    } 
    
}

public class Upcast_DownCast {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>(Arrays.asList(
            new Doctor("SK",21,50000,"Heart Surgean"),
            new Doctor("Kishore",22,40000,"Numeralogist "),
            new Cashier("Balaji",23,50000),
            new Cashier("Mani",24,60000))
        );

        for(Employee obj :emp)
            obj.info();
        System.out.println("---------------");
        for(Employee obj : emp){
            if(obj instanceof Doctor){
                ((Doctor)(obj)).role();
            }
            if(obj instanceof Cashier){
                ((Cashier)(obj)).role();
            }
            System.out.println();
        }    

    }
}
