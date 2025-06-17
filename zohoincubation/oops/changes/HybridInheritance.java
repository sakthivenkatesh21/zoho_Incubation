package zohoincubation.oops.changes;

interface Login{
    String login();
}

interface Pay{
    String payment();
}

class User{
    private String name;
    private int age;
    private String gender;
    User(String name,int age, String gender){
        this.name = name ;
        this.age  = age ;
        this.gender = gender;
    }
    String userInfo(){
        if(age>5 && age <120 ){
            return "Name :"+name+"\nGender: "+gender+"Age: "+age;
        }
        else
            return "Invalid Info Age should be above 5 and below 120 is Eligible";
    }
}
class Bus {
    private String seatType;
    private User user;
    Bus(User user,String seatType){
        this.user = user;
        this.seatType = seatType;
    }
    String seat(){
        if(seatType.equalsIgnoreCase("Semi-Sleeper") || seatType.equalsIgnoreCase("Sleeper"))
            return "Seat selected is"+seatType;
        else 
            return "Ivalid Seat ";    
    }
    String userInfo(){
        return user.userInfo();
    } 

}

class ZoloBus extends Bus implements Login,Pay{
    private int pay ;
    ZoloBus(User user, String seat,int pay){
        super( user,seat);
        this.pay = pay;
    }
    public String login(){
        return "Zolo Bus Login Suucessfully";
    }
    public String  payment( ){
        return pay >0 ? "Payment Credited" : "Payment Failed";
    }
}
public class HybridInheritance {
    public static void main(String[] args) {
        User person1 = new User("Karthi", 22, "Male");
        User person2 = new User("Shri",33,"Female");

        ZoloBus pass1 = new ZoloBus( person1,"Semi-Sleeper",200);
        ZoloBus pass2 = new ZoloBus(person2, "Sleeper",0);
        printbooking(pass1);
        printbooking(pass2);
    }
    private static void printbooking(ZoloBus booking){
        System.out.println(booking.login());
        System.out.println(booking.userInfo());
        System.out.println(booking.seat());
        System.out.println(booking.payment());
    }
}

