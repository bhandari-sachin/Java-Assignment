package BankAccountSys;

public class BankAccount {

    // Instance variables
    private final int accountNumber;
    private double balance;

    // Static variable
    private static int totalAccounts = 0;
    private static int nextAccountNumber = 1;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.accountNumber = nextAccountNumber++;
        totalAccounts++;
    }

    // Instance method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited €" + amount + " to account number " + accountNumber);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    // Instance method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn €" + amount + " from account number " + accountNumber);
            } else {
                System.out.println("Insufficient balance in the account.");
            }
        } else {
            System.out.println("Withdraw amount must be greater than 0.");
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Static method to get total number of accounts
    public int getAccountNumber() {
        return accountNumber;
    }

    // Static method to get total number of accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }


    // Main method to test the class
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(1000);
        BankAccount bankAccount2 = new BankAccount(2000);

        bankAccount1.deposit(500);
        bankAccount2.withdraw(800);


        System.out.println("Account " + bankAccount1.getAccountNumber() + " balance: €" + bankAccount1.getBalance());
        System.out.println("Account " + bankAccount2.getAccountNumber() + " balance: €" + bankAccount2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }


}
