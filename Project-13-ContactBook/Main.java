import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("📒 Contact Book App");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    contacts.add(new Contact(name, phone, email));
                    System.out.println("✅ Contact added!");
                    break;

                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("📭 No contacts found.");
                    } else {
                        System.out.println("📃 Contact List:");
                        for (Contact contact : contacts) {
                            System.out.println(contact);
                        }
                    }
                    break;

                case 3:
                    System.out.print("🔍 Enter name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (Contact c : contacts) {
                        if (c.getName().equalsIgnoreCase(searchName)) {
                            System.out.println("✅ Found: " + c);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("❌ Contact not found.");
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    boolean removed = contacts.removeIf(c -> c.getName().equalsIgnoreCase(deleteName));
                    if (removed) {
                        System.out.println("🗑️ Contact deleted.");
                    } else {
                        System.out.println("❌ No contact found to delete.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("👋 Exiting Contact Book.");
                    break;

                default:
                    System.out.println("❌ Invalid option.");
            }
        }

        sc.close();
    }
}
