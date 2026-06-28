import service.Bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("\n===== BANKING SYSTEM =====");

            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Check Balance");
            System.out.println("7. Print Statement");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    sc.nextLine();
                    String sName = sc.nextLine();

                    System.out.print("Initial Balance: ");
                    double sBalance = sc.nextDouble();

                    bank.createSavingsAccount(
                            sName,
                            sBalance
                    );
                    break;

                case 2:
                    System.out.print("Name: ");
                    sc.nextLine();
                    String cName = sc.nextLine();

                    System.out.print("Initial Balance: ");
                    double cBalance = sc.nextDouble();

                    bank.createCurrentAccount(
                            cName,
                            cBalance
                    );
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    int depAcc = sc.nextInt();

                    System.out.print("Amount: ");
                    double depAmount = sc.nextDouble();

                    bank.deposit(
                            depAcc,
                            depAmount
                    );
                    break;

                case 4:
                    System.out.print("Account Number: ");
                    int wdAcc = sc.nextInt();

                    System.out.print("Amount: ");
                    double wdAmount = sc.nextDouble();

                    bank.withdraw(
                            wdAcc,
                            wdAmount
                    );
                    break;

                case 5:
                    System.out.print("Sender Account: ");
                    int sender = sc.nextInt();

                    System.out.print("Receiver Account: ");
                    int receiver = sc.nextInt();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    bank.transfer(
                            sender,
                            receiver,
                            amount
                    );
                    break;

                case 6:
                    System.out.print("Account Number: ");
                    int balAcc = sc.nextInt();

                    bank.displayBalance(balAcc);
                    break;

                case 7:
                    System.out.print("Account Number: ");
                    int stAcc = sc.nextInt();

                    bank.printStatement(stAcc);
                    break;

                case 8:
                    System.out.println("Thank You.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}