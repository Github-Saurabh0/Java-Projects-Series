import java.util.Scanner;

public class BankSystem {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("🏦 Welcome to Simple Banking System");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();

        account = new BankAccount(name, accNum);
        menu();
    }

    private void menu() {
        while (true) {
            System.out.println("\n📋 Menu:");
            System.out.println("1. View Account Info");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(account.getAccountInfo());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 4:
                    account.viewBalance();
                    break;
                case 5:
                    System.out.println("👋 Thank you for banking with us!");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
