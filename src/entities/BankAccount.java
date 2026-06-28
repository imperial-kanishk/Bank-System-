package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    private final int accountNumber;
    private final String name;
    protected double balance;
    private final List<Transaction> transactions;

    public BankAccount(int accountNumber, String name, double initialBalance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        balance += amount;

        addTransaction(new Transaction("DEPOSIT", amount, "Amount deposited"));

        System.out.println("₹" + amount + " deposited successfully.");
    }

    public abstract void withdraw(double amount);

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void getStatement() {

        System.out.println("\n========== ACCOUNT STATEMENT ==========");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + name);
        System.out.println("Current Balance: ₹" + balance);

        System.out.println("\nTransaction History:");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}