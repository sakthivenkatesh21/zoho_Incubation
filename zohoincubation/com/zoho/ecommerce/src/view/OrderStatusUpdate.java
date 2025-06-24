package zohoincubation.com.zoho.ecommerce.src.view;

import zohoincubation.com.zoho.ecommerce.src.model.Order;
import zohoincubation.com.zoho.ecommerce.src.model.OrderStatus;

class OrderStatusUpdate {

    private static void printOrderStatus(String productName, int orderId, String transactionId, String status) {
        System.out.println("""
            ╔════════════════════════════════════════════════════╗
            ║                    ORDER STATUS                    ║
            ╠════════════════════════════════════════════════════╣
            ║ 📦 Client Name    : %-60s ║
            ║ 🆔 Order ID       : %-60s ║
            ║ 🔁 Transaction    : %-60s ║
            ║ 🚚 Order Status   : %-60s ║
            ╚════════════════════════════════════════════════════╝
            
            """.formatted(productName, orderId, transactionId, status));
    }

    public static void flow(Order order) {
        String[] statuses = new String[]{
            OrderStatus.CONFIRMED.getLabel(),
            OrderStatus.SHIPPED.getLabel(),
            OrderStatus.DELIVERED.getLabel()
        };

        for (String status : statuses) {
            printOrderStatus(order.getClient().getName(), order.getId(), order.getPayment(), status);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("⚠️ Status update interrupted.");
            }
        }
    }
}
