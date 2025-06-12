class Mobile{
    private String  brand;
    private String  model;
    private String color;
    private int storage;
    public Mobile(String brand, String model, String color,int storage){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.storage = storage;
    }
    public  void test(){
        powerOn();
        powerOff();
    }

    public String getColor() {
        return color;
    }
    public int getStorage() {
        return storage;
    }
    public void powerOn(){
        System.out.println(brand+" "+model+" Powered ON Successfully");
    }
    public void powerOff(){
        System.out.println(brand+" "+model+"Power OFF Successfully");
    }
}
class ClassObject{
    public static void main(String[] args){
        Mobile obj1 = new Mobile("Poco","X4 pro 5g","Blue",256);
        Mobile obj2 = new Mobile("Mi","Note 10 pro","Yellow",128);
        Mobile obj3 = new Mobile("Iphone","15 PRO MAX","White",512);
        obj1.test();
        obj2.test();
        obj3.test();

    }
}

