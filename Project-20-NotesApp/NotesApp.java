import java.io.*;
import java.util.Scanner;

public class NotesApp {
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n📝 Notes Application");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Clear All Notes");
            System.out.println("4. Exit");
            System.out.print("👉 Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Clear buffer

            switch (choice) {
                case 1 -> addNote(sc);
                case 2 -> viewNotes();
                case 3 -> clearNotes();
                case 4 -> System.out.println("👋 Exiting... Thank you!");
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    static void addNote(Scanner sc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            System.out.print("✍️ Write your note: ");
            String note = sc.nextLine();
            fw.write(note + "\n");
            System.out.println("✅ Note added successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    static void viewNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n📄 All Notes:");
            while ((line = br.readLine()) != null) {
                System.out.println("🗒️ " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No notes found. Start writing!");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    static void clearNotes() {
        try {
            new FileWriter(FILE_NAME, false).close();
            System.out.println("🧹 All notes cleared.");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
