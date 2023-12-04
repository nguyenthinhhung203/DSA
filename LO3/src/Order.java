import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String orderDate;
    private long totalAmount;
    private String customerName;
    private String customerPhone;
    private List<OrderItem> orderItems;

    private boolean status = false;

    public Order(int id) {
        this.id = id;
        orderItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void printOrder(){
        System.out.println("----------------------------------------------");
        System.out.println("Order - " + id);
        System.out.printf("Customer: %s, %s \n", customerName, customerPhone);
        System.out.println("Status: " + status);
        System.out.println("Total Amount: "+totalAmount); // Nen format tien
        System.out.println("Ma san pham - Ten san pham - Gia - So luong");
        for (OrderItem orderItem: orderItems) {
            System.out.printf("%d - %s - %d - %d \n",orderItem.getItem().getId(),
                    orderItem.getItem().getName(), orderItem.getItem().getPrice(), orderItem.getQuanity());
        }
        System.out.println("----------------------------------------------");
    }
}
