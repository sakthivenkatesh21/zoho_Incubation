class Details{
    String name;
    int age;
    String gender;
//    static int k =11;
    Details(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
     String printDetails(){
        return name+" "+age+" "+gender;
    }
    // public static void m(){
    //     System.out.println("Mmm"+k);
    // }
}
class Student extends Details{
//    static int k=10;
    String collegeName;
    Student(String name, int age, String gender, String collegeName){
        super(name, age, gender);
        this.collegeName = collegeName;
    }
    protected String printDetails(){
        return name+" "+age+" "+gender+" "+collegeName;
    }
    // public static void m(){
    //     System.out.println("kdk"+k);
    // }
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

        // Student d = new Student("", 0, "dnjd","vTU");
        // d.m();

        Details stu = new Student("John Doe", 10, "Male","VTU");
        printDetails(stu);
        Details emp = new Employee("Kishore",24,"Male","KLU University",20000);
        printDetails(emp);
    }
    private static void printDetails(Details details){
        System.out.println(details.printDetails());
    }
}

