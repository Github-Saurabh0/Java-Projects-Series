import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email;
        String choice;

        System.out.println("📧 Email Validator Tool");

        do {
            System.out.print("🔎 Enter email to validate: ");
            email = sc.nextLine();

            if (isValidEmail(email)) {
                System.out.println("✅ '" + email + "' is a Valid Email");
            } else {
                System.out.println("❌ '" + email + "' is NOT a Valid Email");
            }

            System.out.print("🔁 Want to check another? (yes/no): ");
            choice = sc.nextLine().trim().toLowerCase();
        } while (choice.equals("yes") || choice.equals("y"));

        System.out.println("👋 Thank you for using Email Validator!");
        sc.close();
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
