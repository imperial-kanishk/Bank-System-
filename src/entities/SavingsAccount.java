package entities;

public class SavingsAccount extends BankAccount {

    private static final double minbalance = 1000.0;

    public SavingsAccount(int accountNumber,
                          String name,
                          double initialBalance) {

        super(accountNumber, name, initialBalance);

        if (initialBalance < minbalance) {
            throw new IllegalArgumentException(
                    "Savings Account requires minimum balance of ₹" + minbalance);
        }
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        if (balance - amount < minbalance) {
            System.out.println("Withdrawal denied. Minimum balance of ₹" + minbalance +
                            " must be maintained."
            );
            return;
        }

        balance -= amount;

        addTransaction(
                new Transaction(
                        "WITHDRAW",
                        amount,
                        "Withdrawal from Savings Account"));

        System.out.println("₹" + amount + " withdrawn successfully.");
    }
}