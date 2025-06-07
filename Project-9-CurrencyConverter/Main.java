import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String from, to;
        double amount;

        System.out.println("💱 Welcome to Currency Converter");
        CurrencyConverter.showSupportedCurrencies();

        System.out.print("Enter source currency (INR or USD/EUR/GBP/JPY): ");
        from = sc.next().toUpperCase();

        System.out.print("Enter target currency: ");
        to = sc.next().toUpperCase();

        System.out.print("Enter amount: ");
        amount = sc.nextDouble();

        double result = 0;
        if (from.equals("INR")) {
            result = CurrencyConverter.convertINRTo(to, amount);
        } else if (to.equals("INR")) {
            result = CurrencyConverter.convertToINR(from, amount);
        } else {
            System.out.println("❌ Conversion between foreign currencies not supported.");
            return;
        }

        if (result == -1) {
            System.out.println("❌ Invalid currency code.");
        } else {
            System.out.printf("✅ Converted Amount: %.2f %s%n", result, to);
        }
    }
}
