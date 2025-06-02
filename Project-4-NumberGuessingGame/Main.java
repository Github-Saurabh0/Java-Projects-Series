import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        boolean isGuessed = false;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100...");

        while (!isGuessed) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("📉 Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("📈 Too high! Try again.");
            } else {
                System.out.println("🎉 Congratulations! You guessed it in " + attempts + " attempts.");
                isGuessed = true;
            }
        }

        System.out.println("🔁 Game Over. Thanks for playing!");
    }
}
