import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🔢 Number to Word Converter (0-999)");
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        String word = NumberToWords.convert(number);
        System.out.println("🗣 In Words: " + word);
    }
}
