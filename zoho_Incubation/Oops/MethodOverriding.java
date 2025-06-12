class Details{
    String name;
    int age;
    String gender;
    
    Details(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String printDetails(){
        return name+" "+age+" "+gender;
    }
}
class Student extends Details{
    String collegeName;
    Student(String name, int age, String gender, String collegeName){
        super(name, age, gender);
        this.collegeName = collegeName;
    }
    public String printDetails(){
        return name+" "+age+" "+gender+" "+collegeName;
    }
}
class Employee extends Student{
    double salary;
    Employee(String name, int age, String gender,String collegeName, double salary){
        super(name, age, gender,collegeName);
        this.salary = salary>0 ?salary : 0.0;
    }
    public String printDetails(){
        return name+" "+age+" "+gender+" "+collegeName+" "+salary;
    }
}
public class MethodOverriding {
    public static void main(String[] args) {
        // Student stu1 = new Student("John Doe", 10, "Male","VTU");

        Details stu = new Student("John Doe", 10, "Male","VTU");
        printDetails(stu);
        Details emp = new Employee("Kishore",24,"Male","KLU University",20000);
        printDetails(emp);
    }
    private static void printDetails(Details details){
        System.out.println(details.printDetails());
    }
}

