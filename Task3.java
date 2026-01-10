package ATM;

import java.util.Scanner;

class User_interface {

    private BankAccount account;
    private Scanner sc;

    public User_interface(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void menu() {
        int choice;

        do {
            System.out.println("ATM Menu - Select one : ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println(" Thank you for using ATM.");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private void checkBalance() {
        System.out.println(" Current Balance: " + account.getBalance());
    }
}

package ATM;

class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Amount deposited successfully.");
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Invalid withdrawal amount.");
        }
        else if (amount > balance) {
            System.out.println(" Insufficient balance.");
        }
        else {
            balance -= amount;
            System.out.println(" Amount withdrawn successfully.");
        }
    }

    public double getBalance() {
        return balance;
    }
}
package ATM;

public class Task3 {

    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(10000);
        User_interface atm = new User_interface(userAccount);

        atm.menu();
    }
}
