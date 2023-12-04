import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static QueueADT<Order> orderQueueADT = new QueueADTImpl<>(100);
    private static List<Product> productList = new ArrayList<>();

    static {
        // Khởi tạo danh sách sản phẩm có sẵn (có thể thay đổi theo nhu cầu)
        productList.add(new Product(1, "San pham 1", 1000));
        productList.add(new Product(2, "San pham 2", 3000));
        // Thêm các sản phẩm khác nếu cần
    }


    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tạo hóa đơn");
            System.out.println("2. Duyệt đơn hàng");
            System.out.println("3. Hiển thị ra tất cả đơn hàng theo giá tăng dần");
            System.out.println("0. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    processOrders();
                    break;
                case 3:
                    displayOrdersByPrice();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void createOrder() {
        System.out.println("Danh sách sản phẩm có sẵn:");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("Nhập thông tin hóa đơn:");

        System.out.print("Tên người nhận: ");
        String customerName = scanner.nextLine();

        System.out.print("Số điện thoại: ");
        String customerPhone = scanner.nextLine();

        System.out.print("Ngày đặt (yyyy-MM-dd): ");
        String orderDate = scanner.nextLine();

        Order newOrder = new Order(orderQueueADT.size() + 1);
        newOrder.setCustomerName(customerName);
        newOrder.setCustomerPhone(customerPhone);
        newOrder.setOrderDate(orderDate);

        System.out.println("Thêm sản phẩm vào hóa đơn (nhập '0' để kết thúc):");
        while (true) {
            System.out.print("Mã sản phẩm: ");
            int productId = scanner.nextInt();

            if (productId == 0) {
                break;
            }

            System.out.print("Số lượng: ");
            int quantity = scanner.nextInt();

            // Tìm sản phẩm trong danh sách sản phẩm có sẵn
            // (Bạn cần có danh sách sản phẩm có sẵn hoặc sử dụng một cơ sở dữ liệu)
            Product product = getProductById(productId);

            if (product != null) {
                newOrder.getOrderItems().add(new OrderItem(newOrder.getOrderItems().size() + 1, product, quantity));
            } else {
                System.out.println("Không tìm thấy sản phẩm với mã " + productId);
            }
        }

        // Tính tổng tiền
        long totalAmount = 0;
        for (OrderItem orderItem : newOrder.getOrderItems()) {
            totalAmount += orderItem.getItem().getPrice() * orderItem.getQuanity();
        }
        newOrder.setTotalAmount(totalAmount);

        // Thêm hóa đơn vào hàng đợi
        orderQueueADT.enqueue(newOrder);

        System.out.println("Đã thêm hóa đơn vào hàng đợi.");
    }

    private static void processOrders() {
        System.out.println("Duyệt và xử lý đơn hàng:");
        List<Order> processedOrders = new ArrayList<>();

        while (true) {
            Order order = orderQueueADT.dequeue();
            if (order == null) {
                System.out.println("Hết đơn hàng trong hàng đợi.");
                break;
            }

            order.setStatus(true);
            processedOrders.add(order);
        }
        processedOrders.sort(Comparator.comparingLong(Order::getTotalAmount));

        // Hiển thị đơn hàng đã sắp xếp
        for (Order order : processedOrders) {
            order.printOrder();
        }
    }

    private static void displayOrdersByPrice() {
        // Sắp xếp danh sách đơn hàng theo tổng tiền tăng dần
        List<Order> tempOrders = new ArrayList<>();

        while (true) {
            Order order = orderQueueADT.dequeue();
            if (order == null) {
                break;
            }
            tempOrders.add(order);
        }

        // Sắp xếp danh sách tạm thời theo giá trị tăng dần
        tempOrders.sort(Comparator.comparingLong(Order::getTotalAmount));

        // Hiển thị danh sách đã sắp xếp
        for (Order order : tempOrders) {
            order.printOrder();
        }

        // Thêm lại các đơn hàng vào hàng đợi
        for (Order order : tempOrders) {
            orderQueueADT.enqueue(order);
        }
    }





    // Phương thức giả định: Lấy sản phẩm từ danh sách sản phẩm có sẵn
    private static Product getProductById(int productId) {
        // Giả sử có một danh sách sản phẩm đã khai báo ở đây hoặc sử dụng cơ sở dữ liệu
        // để lấy thông tin sản phẩm dựa vào mã sản phẩm
        // (Đây chỉ là một giả định, bạn cần điều chỉnh theo cách bạn tổ chức dữ liệu sản phẩm)
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "San pham 1", 1000));
        productList.add(new Product(2, "San pham 2", 3000));

        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}
