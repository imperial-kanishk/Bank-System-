package service;

import DAO.AccountDAO;
import entities.BankAccount;

public class Bank {

    private final AccountDAO dao;

    public Bank() {

        dao = new AccountDAO();

        dao.createTable();
    }

    private int generateAccountNumber() {

        return (int) (Math.random() * 900000000)
                + 100000000;
    }

    public void createSavingsAccount(String name,
                                     double initialBalance) {

        int accountNumber =
                generateAccountNumber();

        dao.insertAccount(
                accountNumber,
                name,
                initialBalance,
                "SAVINGS"
        );

        System.out.println(
                "The Savings Account for user "
                        + name +
                        " has been created."
        );

        System.out.println(
                "The Account for the user "
                        + name +
                        " is "
                        + accountNumber
        );
    }

    public void createCurrentAccount(String name,
                                     double initialBalance) {

        int accountNumber =
                generateAccountNumber();

        dao.insertAccount(
                accountNumber,
                name,
                initialBalance,
                "CURRENT"
        );

        System.out.println(
                "The Current Account for user "
                        + name +
                        " has been created."
        );

        System.out.println(
                "The Account for the user "
                        + name +
                        " is "
                        + accountNumber
        );
    }

    public BankAccount findAccount(int accountNumber) {

        return dao.getAccount(accountNumber);
    }

    public void deposit(int accountNumber,
                        double amount) {

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {

            System.out.println(
                    "Account not found."
            );
            return;
        }

        account.deposit(amount);

        dao.updateBalance(
                accountNumber,
                account.getBalance()
        );
    }

    public void withdraw(int accountNumber,
                         double amount) {

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {

            System.out.println(
                    "Account not found."
            );
            return;
        }

        account.withdraw(amount);

        dao.updateBalance(
                accountNumber,
                account.getBalance()
        );
    }

    public void transfer(int fromAccount,
                         int toAccount,
                         double amount) {

        BankAccount sender =
                findAccount(fromAccount);

        BankAccount receiver =
                findAccount(toAccount);

        if (sender == null ||
                receiver == null) {

            System.out.println(
                    "Account not found."
            );
            return;
        }

        sender.withdraw(amount);

        receiver.deposit(amount);

        dao.updateBalance(
                fromAccount,
                sender.getBalance()
        );

        dao.updateBalance(
                toAccount,
                receiver.getBalance()
        );

        System.out.println(
                "Transfer successful."
        );
    }

    public void displayBalance(int accountNumber) {

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {

            System.out.println(
                    "Account not found."
            );
            return;
        }

        System.out.println(
                "Current Balance: ₹"
                        + account.getBalance()
        );
    }

    public void printStatement(int accountNumber) {

        BankAccount account =
                findAccount(accountNumber);

        if (account == null) {

            System.out.println(
                    "Account not found."
            );
            return;
        }

        account.getStatement();
    }
}