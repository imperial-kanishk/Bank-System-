package entities;

public class CurrentAccount extends BankAccount{
    public CurrentAccount(int accountNumber, String name, double initialBalance) {
        super(accountNumber, name, initialBalance);
    }

    @Override
    public void withdraw(double amt) {
        if(amt<=0){
            System.out.println("Withdrawal must be positive");
            return;
        }
        if(amt > balance ){
            System.out.println("Insufficient balance");
            return;

        }
        balance-=amt;
        Transaction transaction = new Transaction(
                "WITHDRAW",
                amt,
                "Withdrawal from Current Account"
        );

        addTransaction(transaction);
        System.out.println("₹" + amt + " withdrawn successfully.");
    }
}
