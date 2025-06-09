import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🔐 Password Strength Checker");

        while (true) {
            System.out.print("Enter password to check (or 'exit' to quit): ");
            String password = sc.nextLine();

            if (password.equalsIgnoreCase("exit")) {
                System.out.println("👋 Exiting...");
                break;
            }

            String result = PasswordChecker.checkStrength(password);
            System.out.println("Result: " + result);
        }
    }
}
