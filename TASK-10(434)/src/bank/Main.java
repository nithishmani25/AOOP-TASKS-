package bank;

public class Main {
    public static void main(String[] args) {
        // Instantiate an Account object with account number 1001 and initial balance $1000
        Account account = new Account(1001, 1000.0);

        // Create threads using TransactionRunnable (Runnable interface)
        Thread runnableThread1 = new Thread(new TransactionRunnable(account, 500.0, true));  // Deposit $500
        Thread runnableThread2 = new Thread(new TransactionRunnable(account, 200.0, false)); // Withdraw $200

        // Create threads using TransactionThread (extends Thread class)
        TransactionThread threadThread1 = new TransactionThread(account, 300.0, true);       // Deposit $300
        TransactionThread threadThread2 = new TransactionThread(account, 150.0, false);      // Withdraw $150

        // Start all threads
        runnableThread1.start();
        runnableThread2.start();
        threadThread1.start();
        threadThread2.start();

        // Wait for all threads to complete
        try {
            runnableThread1.join();
            runnableThread2.join();
            threadThread1.join();
            threadThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        // Print final balance
        System.out.println("\nFinal balance for account " + account.getAccountNumber() + ": $" + account.getBalance());
    }
}