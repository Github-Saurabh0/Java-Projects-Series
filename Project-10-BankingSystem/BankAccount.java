public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("✅ Withdrawn ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount");
        }
    }

    public void viewBalance() {
        System.out.printf("💰 Balance: ₹%.2f%n", balance);
    }

    public String getAccountInfo() {
        return "👤 Account Holder: " + accountHolderName + "\n🏦 Account Number: " + accountNumber;
    }
}
