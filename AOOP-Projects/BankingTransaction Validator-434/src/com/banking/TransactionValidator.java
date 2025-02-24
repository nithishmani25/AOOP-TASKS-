package com.banking;

import java.util.Scanner;
import java.util.function.Function;

public class TransactionValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter account number (10 digits): ");
        String accountNumber = scanner.next();

        System.out.print("Is the transaction fraudulent? (true/false): ");
        boolean isFraudulent = scanner.nextBoolean();

        // Create transaction object
        Transaction transaction = new Transaction(amount, accountNumber, isFraudulent);

        // Functional Interfaces for validation
        Function<Transaction, Boolean> validateAmount = txn -> txn.getAmount() > 0;
        Function<Transaction, Boolean> validateAccount = txn -> txn.getAccountNumber().matches("\\d{10}");
        Function<Transaction, Boolean> validateFraud = txn -> !txn.isFraudulent();

        // Apply Validations
        boolean isValid = validateAmount.apply(transaction) &&
                          validateAccount.apply(transaction) &&
                          validateFraud.apply(transaction);

        // Print Result
        if (isValid) {
            System.out.println("Transaction is valid and processed.");
        } else {
            System.out.println("Transaction validation failed!");
        }

        scanner.close();
    }
}
