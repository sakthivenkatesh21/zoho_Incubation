package zohoincubation.com.zoho.ecommerce.src.model;

public  enum OrderStatus {
    
    SHIPPED,DELEVIRED,PENDING;

    public String get(){
        switch (this) {
            case SHIPPED:
                return "SHIPPED";
                
            case DELEVIRED:
                return "DELEVIRED";

            case PENDING:
                return "PENDING";
        
            default:
                return "Invalid Input";
        }
    }

}

