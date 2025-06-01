import java.util.ArrayList;

public class ATM {
    private User user;
    private ArrayList<String> miniStatement = new ArrayList<>();

    public ATM(User user) {
        this.user = user;
    }

    public boolean authenticate(String userId, int pin) {
        return user.getUserId().equals(userId) && user.getPin() == pin;
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + user.getBalance());
    }

    public void deposit(double amount) {
        user.deposit(amount);
        miniStatement.add("Deposited ₹" + amount);
        System.out.println("✅ ₹" + amount + " deposited successfully!");
    }

    public void withdraw(double amount) {
        if (user.withdraw(amount)) {
            miniStatement.add("Withdrew ₹" + amount);
            System.out.println("✅ ₹" + amount + " withdrawn successfully!");
        } else {
            System.out.println("❌ Insufficient balance!");
        }
    }

    public void showMiniStatement() {
        System.out.println("📄 Mini Statement:");
        for (String record : miniStatement) {
            System.out.println("- " + record);
        }
        if (miniStatement.isEmpty()) {
            System.out.println("⚠️ No transactions yet.");
        }
    }
}
