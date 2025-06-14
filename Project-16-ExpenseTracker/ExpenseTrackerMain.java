import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTrackerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();
        boolean running = true;

        System.out.println("💸 Welcome to Simple Expense Tracker");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Filter by Category");
            System.out.println("4. Total Expenses");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter category (e.g., Food, Travel): ");
                    String cat = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    expenses.add(new Expense(cat, amt));
                    System.out.println("✅ Expense added.");
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("📭 No expenses yet.");
                    } else {
                        System.out.println("🧾 All Expenses:");
                        for (Expense e : expenses) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter category to filter: ");
                    String filter = sc.nextLine();
                    boolean found = false;
                    for (Expense e : expenses) {
                        if (e.getCategory().equalsIgnoreCase(filter)) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("❌ No expenses found for that category.");
                    break;

                case 4:
                    double total = 0;
                    for (Expense e : expenses) {
                        total += e.getAmount();
                    }
                    System.out.printf("💰 Total Spent: %.2f INR%n", total);
                    break;

                case 5:
                    running = false;
                    System.out.println("👋 Exiting Expense Tracker.");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }

        sc.close();
    }
}
