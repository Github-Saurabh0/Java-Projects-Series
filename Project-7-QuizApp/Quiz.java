import java.util.Scanner;

public class Quiz {
    private Question[] questions;
    private int score;

    public Quiz() {
        questions = new Question[5];

        questions[0] = new Question("What is the capital of India?",
            new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 2);

        questions[1] = new Question("Which language is used in Android development?",
            new String[]{"Python", "Swift", "Kotlin", "PHP"}, 3);

        questions[2] = new Question("Who is the founder of Microsoft?",
            new String[]{"Elon Musk", "Steve Jobs", "Bill Gates", "Larry Page"}, 3);

        questions[3] = new Question("What is the full form of JVM?",
            new String[]{"Java Virtual Machine", "Java Volume Meter", "Just Very Mighty", "None"}, 1);

        questions[4] = new Question("Which of these is not an OOP concept?",
            new String[]{"Encapsulation", "Abstraction", "Polymorphism", "Compilation"}, 4);
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n🔹 Question " + (i + 1));
            questions[i].displayQuestion();
            System.out.print("Your answer (1-4): ");
            int answer = sc.nextInt();

            if (questions[i].isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
            }
        }

        System.out.println("\n🎯 Quiz Over!");
        System.out.println("🏆 You scored: " + score + " out of " + questions.length);
    }
}
