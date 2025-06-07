import java.util.HashMap;

public class CurrencyConverter {

    private static final HashMap<String, Double> rates = new HashMap<>();

    static {
        rates.put("USD", 0.012); // 1 INR = 0.012 USD
        rates.put("EUR", 0.011); // 1 INR = 0.011 EUR
        rates.put("GBP", 0.0095); // 1 INR = 0.0095 GBP
        rates.put("JPY", 1.67);   // 1 INR = 1.67 JPY
    }

    public static double convertINRTo(String currency, double amount) {
        if (rates.containsKey(currency)) {
            return amount * rates.get(currency);
        }
        return -1;
    }

    public static double convertToINR(String currency, double amount) {
        if (rates.containsKey(currency)) {
            return amount / rates.get(currency);
        }
        return -1;
    }

    public static void showSupportedCurrencies() {
        System.out.println("Supported currencies: " + rates.keySet());
    }
}
