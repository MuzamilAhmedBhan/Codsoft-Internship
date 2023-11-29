import java.util.*;
public class q3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        ATM atm = new ATM(account);

        atm.displayMenu();
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

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
                    System.out.println("Exiting the ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();

        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount. Withdrawal failed.");
        }
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();

        userAccount.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }
}

class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
