import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n🎯 UNIT CONVERTER MENU");
            System.out.println("1. Length (Meter ↔ Kilometer)");
            System.out.println("2. Weight (Kilogram ↔ Gram)");
            System.out.println("3. Temperature (Celsius ↔ Fahrenheit)");
            System.out.println("4. Exit");
            System.out.print("🔢 Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> convertLength(sc);
                case 2 -> convertWeight(sc);
                case 3 -> convertTemperature(sc);
                case 4 -> System.out.println("👋 Exiting...");
                default -> System.out.println("❌ Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }

    static void convertLength(Scanner sc) {
        System.out.print("📏 Enter length in meters: ");
        double meters = sc.nextDouble();
        double kilometers = meters / 1000;
        System.out.println("✅ " + meters + " meters = " + kilometers + " kilometers");
    }

    static void convertWeight(Scanner sc) {
        System.out.print("⚖️ Enter weight in kilograms: ");
        double kg = sc.nextDouble();
        double grams = kg * 1000;
        System.out.println("✅ " + kg + " kg = " + grams + " grams");
    }

    static void convertTemperature(Scanner sc) {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("📌 Enter option: ");
        int opt = sc.nextInt();

        if (opt == 1) {
            System.out.print("🌡 Enter temperature in Celsius: ");
            double c = sc.nextDouble();
            double f = (c * 9/5) + 32;
            System.out.println("✅ " + c + "°C = " + f + "°F");
        } else if (opt == 2) {
            System.out.print("🌡 Enter temperature in Fahrenheit: ");
            double f = sc.nextDouble();
            double c = (f - 32) * 5/9;
            System.out.println("✅ " + f + "°F = " + c + "°C");
        } else {
            System.out.println("❌ Invalid option.");
        }
    }
}
