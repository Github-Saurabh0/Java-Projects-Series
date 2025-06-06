import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n📝 To-Do List Menu");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markAsDone();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("👋 Exiting. Stay productive!");
                    return;
                default:
                    System.out.println("❗ Invalid choice.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter task description: ");
        String desc = sc.nextLine();
        tasks.add(new Task(desc));
        System.out.println("✅ Task added.");
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks found.");
            return;
        }
        System.out.println("\n📋 Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void markAsDone() {
        viewTasks();
        System.out.print("Enter task number to mark as done: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
            System.out.println("✅ Task marked as done.");
        } else {
            System.out.println("❌ Invalid task number.");
        }
    }

    private void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("🗑️ Task deleted.");
        } else {
            System.out.println("❌ Invalid task number.");
        }
    }
}
