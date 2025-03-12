package bank;

public class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount: $" + amount);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from account " + accountNumber + ". New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount: $" + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal of $" + amount + " from account " + accountNumber + ". Current balance: $" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}