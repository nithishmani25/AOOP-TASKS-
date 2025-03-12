class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized deposit method
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
        }
    }

    // Synchronized withdraw method
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw: " + amount + " (Insufficient funds)");
        }
    }

    // Get current balance
    public synchronized double getBalance() {
        return balance;
    }
}

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000);

        Runnable user1 = () -> {
            sharedAccount.deposit(500);
            sharedAccount.withdraw(300);
        };

        Runnable user2 = () -> {
            sharedAccount.withdraw(700);
            sharedAccount.deposit(200);
        };

        Thread thread1 = new Thread(user1, "User 1");
        Thread thread2 = new Thread(user2, "User 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + sharedAccount.getBalance());
    }
}
