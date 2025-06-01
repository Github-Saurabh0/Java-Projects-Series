import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // long BalanceMine = 60000000000l ;
        User user = new User("Saurabhh", 1234, 6000000000L );
        ATM atm = new ATM(user);

        System.out.print("👤 Enter User ID: ");
        String userId = sc.nextLine();
        System.out.print("🔒 Enter PIN: ");
        int pin = sc.nextInt();

        if (!atm.authenticate(userId, pin)) {
            System.out.println("❌ Authentication Failed. Exiting.");
            return;
        }

        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    atm.deposit(deposit);
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double withdraw = sc.nextDouble();
                    atm.withdraw(withdraw);
                    break;
                case 4:
                    atm.showMiniStatement();
                    break;
                case 5:
                    System.out.println("👋 Thank you! Visit again.");
                    return;
                default:
                    System.out.println("❗ Invalid choice.");
            }
        }
    }
}
