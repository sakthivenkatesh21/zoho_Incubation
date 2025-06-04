class User{
    private String name;
    private int age;
    private String gender;
    User(String name,int age, String gender){
        this.name = name ;
        this.age  = age ;
        this.gender = gender;
    }
    void userInfo(){
        System.out.println("Name :"+name+"\nGender: "+gender+"\nAge: "+age);
    }
}
class Bus extends User{
    private String seatType;
    Bus(String name , int age,String gender,String seatType){
        super(name, age, gender);
        this.seatType = seatType;
    }
    void seat(){
        System.out.println("Seat selected is"+seatType);
    }

}
interface Login{
    void login();
}
interface Pay{
    void payment();
}
class ZoloBus extends Bus implements Login,Pay{
    ZoloBus(String name , int age,String gender,String seat){
        super(name, age, gender,seat);
    }
    public void login(){
        System.out.println("Zolo Bus Login Suucessfully");
    }
    public void payment(){
        System.out.println("Payment Credited");
    }
}
public class HybridInheritance {
    public static void main(String[] args) {
        ZoloBus pass1 = new ZoloBus("KARTHI", 22, "Male", "Semi-Sleeper");
        ZoloBus pass2 = new ZoloBus("Shri", 32, "Female", "Sleeper");
        printbooking(pass1);
        printbooking(pass2);
    }
    private static void printbooking(ZoloBus booking){
        booking.login();
        booking.userInfo();
        booking.seat();
        booking.payment();
    }
}
