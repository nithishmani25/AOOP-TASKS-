package refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private double totalAmount;
    private List<String> items;

    public Order(Customer customer, double totalAmount) {
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.items = new ArrayList<>();
    }

    public double calculateOrderDiscount() {
        return customer.calculateDiscount(totalAmount);  // Delegate to Customer
    }

    // Adds an item to the order
    public void addItem(String item) {
        items.add(item);
    }

    // Returns a summary of the order
    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Customer: ").append(customer.getName()).append("\n");
        summary.append("Total Amount: $").append(totalAmount).append("\n");
        summary.append("Items: ").append(String.join(", ", items)).append("\n");
        summary.append("Discount: $").append(calculateOrderDiscount()).append("\n");
        summary.append("Total After Discount: $").append(totalAmount - calculateOrderDiscount()).append("\n");
        return summary.toString();
    }

    // other order-related methods
}
