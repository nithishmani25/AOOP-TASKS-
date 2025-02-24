package com.banking;

public class Transaction {
    private double amount;
    private String accountNumber;
    private boolean isFraudulent;

    // Constructor
    public Transaction(double amount, String accountNumber, boolean isFraudulent) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.isFraudulent = isFraudulent;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}
