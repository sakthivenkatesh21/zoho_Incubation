package zohoincubation.oops.modified;

class Devices {
    String status;
    String brand;
    String type;

    Devices(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    String powerOn(String curr) {
        status = curr.equalsIgnoreCase("ON") ? "Device Powered on"
                : curr.equalsIgnoreCase("OFF") ? "Shutdown"
                : "Invalid Error";
        return status;
    }

    void deviceInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Type: " + type);
    }
}
class Laptop extends Devices {
    int ram;
    int storage;

    Laptop(String brand, String type, int ram, int storage) {
        super(brand, type);
        this.ram = ram;
        this.storage = storage;
    }

    void study() {
        if (status != null && status.equalsIgnoreCase("Device Powered on"))
            System.out.println(" Laptop is Switched ON for studying.");
        else if (status != null && status.equalsIgnoreCase("Shutdown"))
            System.out.println("⚠️ Please Switch ON the laptop first.");
        else
            System.out.println(" Error: " + status);
    }
}
class GamingLaptop extends Laptop {
        String graphicsCard;
        String processor;
    
        GamingLaptop(String brand, String type, int ram, int storage, String graphicsCard, String processor) {
            super(brand, type, ram, storage);
            this.graphicsCard = graphicsCard;
            this.processor = processor;
        }
    
        void gaming() {
            if ((processor.equalsIgnoreCase("i7") || processor.equalsIgnoreCase("Intel 11th Gen"))
                    && graphicsCard != null && !graphicsCard.isEmpty()) {
                System.out.println("Gaming Supported Laptop with " + processor + " and " + graphicsCard);
            } else {
                System.out.println(" Normal usage Laptop. No high-end gaming support.");
            }
        }
    
        void gamingSpec() {
            System.out.println("Graphics Card: " + graphicsCard);
            System.out.println("Processor: " + processor);
        }
}
public class MultilevelInheritance {
    public static void main(String[] args) {
        GamingLaptop gaming = new GamingLaptop("Asus", "Gaming Laptop", 16, 512, "NVIDIA RTX 3060", "i7");
        gaming.deviceInfo();
        System.out.println(gaming.powerOn("on"));
        gaming.study();
        gaming.gaming();
        gaming.gamingSpec();
    }
}



