import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2;
        char operator;
        boolean running = true;

        System.out.println("🧮 Welcome to Mini Calculator");

        while (running) {
            System.out.print("\nEnter first number: ");
            num1 = sc.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            operator = sc.next().charAt(0);

            System.out.print("Enter second number: ");
            num2 = sc.nextDouble();

            switch (operator) {
                case '+':
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case '-':
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case '*':
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case '/':
                    if (num2 != 0) {
                        System.out.println("Result: " + (num1 / num2));
                    } else {
                        System.out.println("❌ Cannot divide by zero.");
                    }
                    break;
                default:
                    System.out.println("❌ Invalid operator.");
            }

            System.out.print("\nDo you want to continue? (yes/no): ");
            String choice = sc.next();
            if (!choice.equalsIgnoreCase("yes")) {
                running = false;
                System.out.println("👋 Exiting Calculator. Thank you!");
            }
        }
    }
}
