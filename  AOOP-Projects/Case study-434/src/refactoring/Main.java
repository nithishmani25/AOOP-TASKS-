package refactoring;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe", true);  // Premium Member
        Order order = new Order(customer, 100.00);

        // Add items to the order
        order.addItem("Laptop");
        order.addItem("Smartphone");

        // Get order summary
        System.out.println(order.getOrderSummary());
    }
}
