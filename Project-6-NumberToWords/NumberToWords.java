public class NumberToWords {

    private static final String[] units = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
        "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String convert(int number) {
        if (number == 0) return "Zero";
        if (number < 0 || number > 999) return "Number out of range (0-999)";

        String result = "";

        if (number >= 100) {
            result += units[number / 100] + " Hundred ";
            number = number % 100;
        }

        if (number < 20) {
            result += units[number];
        } else {
            result += tens[number / 10] + " ";
            result += units[number % 10];
        }

        return result.trim();
    }
}
