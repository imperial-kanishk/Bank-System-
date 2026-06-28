package service;

import entities.BankAccount;
import entities.CurrentAccount;
import entities.SavingsAccount;

import java.util.HashMap;

public class Bank {
        private final HashMap<Integer, BankAccount> bankAccounts;
        private int accountNumber;

    public Bank() {
        this.bankAccounts = new HashMap<>();
        this.accountNumber = 1001;
    }

    public void createSavingsAccount(String name, double initialBalance){
        BankAccount savingsAccount = new SavingsAccount(accountNumber,name,initialBalance);
        bankAccounts.put(accountNumber,savingsAccount);
        System.out.println("The Savings Account for user "+name+" has been created.");
        System.out.println("The Account for the user "+name+" is "+accountNumber);
        accountNumber++;

    }
    public void createCurrentAccount(String name, double initialBalance){
        BankAccount currentAccount = new CurrentAccount(accountNumber,name,initialBalance);
        bankAccounts.put(accountNumber,currentAccount);
        System.out.println("The Current Account for user "+name+" has been created.");
        System.out.println("The Account for the user "+name+" is "+accountNumber);
        accountNumber++;
    }
    public BankAccount findAccount(int accountNumber) {
        return bankAccounts.get(accountNumber);
    }

    public void deposit(int accountNumber,
                        double amount) {

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.deposit(amount);
    }

    public void withdraw(int accountNumber,
                         double amount) {

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.withdraw(amount);
    }

    public void transfer(int fromAccount,
                         int toAccount,
                         double amount) {

        BankAccount sender =
                findAccount(fromAccount);

        BankAccount receiver =
                findAccount(toAccount);

        if (sender == null || receiver == null) {
            System.out.println("Account not found.");
            return;
        }

        sender.withdraw(amount);

        receiver.deposit(amount);

        System.out.println("Transfer successful.");
    }

    public void displayBalance(int accountNumber) {

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println(
                "Current Balance: ₹" +
                        account.getBalance()
        );
    }

    public void printStatement(int accountNumber) {

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.getStatement();
    }
}
