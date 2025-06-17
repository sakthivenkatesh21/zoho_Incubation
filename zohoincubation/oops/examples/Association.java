package zohoincubation.oops.examples;
class Bike{
    private String bikeName;
    private int milege;
    Bike(String bikeName, int milege){
        this.bikeName = bikeName;
        this.milege = milege;
    }
    public String getBikeName() {
        return bikeName;
    }
    public int getMilege() {
        return milege;
    }
    
}
class Book{
    private String bookName;
    private String author;
    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }
    public String getBookName() {
        return bookName;
    }
    public String getAuthor() {
        return author;
    }

}
class Brain{
    private int weight;
    private String color;
    public Brain(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }
    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }
    public String infoBrain(){
        return "Brain info : "+"Weight :"+weight+" color :"+color;
    }
}
class Heart{
    private int weight;
    private String color;
    private int bpm;
    public Heart(int weight, String color, int bpm) {
        this.weight = weight;
        this.color = color;
        this.bpm = bpm;
    }
    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }
    public int getBpm() {
        return bpm;
    }
    public String infoheart(){
        return "HeartInfo : "+"Weight :"+weight+" color :"+color+" BPM :"+bpm;
    }

}
class Human{
    private String name;
    
    public Human(String name) {
        this.name = name;
    }
    Brain brain = new Brain(200,"grey");
    Heart heart = new Heart(240,"Red", 87);
    void hasBike(Bike bike){
        System.out.println(name+" has a "+bike.getBikeName());
        System.out.println(name+" has a bike mileage of "+bike.getMilege());
    }
    void hasBook(Book book){
        System.out.println(name+" has a book "+book.getBookName()+" author is "+book.getAuthor());
    }
} 
public class Association {
    public static void main(String[] args) {
        Bike bike = new Bike("yamaha", 65);
        Book book = new Book("Thirukural","Thiruvalluvar");
        Human person = new Human("Mani");
        compsition(person);
        aggregation(person,bike,book);
        person =null;
        // compsition(person);
        // aggregation(person,bike,book);

        System.out.println(bike.getBikeName());
        System.out.println(bike.getMilege());
        System.out.println(book.getBookName()+" author is "+book.getAuthor());
    }
    private static void compsition(Human person){
        System.out.println(person.brain.infoBrain());
        System.out.println(person.heart.infoheart());
    }
    private  static void aggregation(Human person, Bike bike, Book book){
        person.hasBike(bike);
        person.hasBook(book);
    }
}
