package refactoring;

public class Customer {
    private String name;
    private boolean isPremiumMember;

    // Marking the constructor as public
    public Customer(String name, boolean isPremiumMember) {
        this.name = name;
        this.isPremiumMember = isPremiumMember;
    }

    public String getName() {
        return name;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public double getMembershipDiscount() {
        return isPremiumMember ? 0.1 : 0.05;
    }

    public double calculateDiscount(double totalAmount) {
        return getMembershipDiscount() * totalAmount;
    }

    // other customer-related methods
}
