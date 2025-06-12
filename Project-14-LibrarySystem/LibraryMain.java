import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("📚 Welcome to Library Management System");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    library.add(new Book(title, author));
                    System.out.println("✅ Book added!");
                    break;

                case 2:
                    if (library.isEmpty()) {
                        System.out.println("📭 No books in the library.");
                    } else {
                        System.out.println("📚 Books in Library:");
                        for (Book book : library) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = sc.nextLine();
                    boolean found = false;
                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                            System.out.println("✅ Found: " + book);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("❌ Book not found.");
                    break;

                case 4:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    boolean issued = false;
                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(issueTitle)) {
                            if (!book.isIssued()) {
                                book.issue();
                                System.out.println("📤 Book issued successfully.");
                            } else {
                                System.out.println("⚠️ Book is already issued.");
                            }
                            issued = true;
                        }
                    }
                    if (!issued) System.out.println("❌ Book not found.");
                    break;

                case 5:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    boolean returned = false;
                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                            if (book.isIssued()) {
                                book.returnBook();
                                System.out.println("✅ Book returned.");
                            } else {
                                System.out.println("⚠️ Book was not issued.");
                            }
                            returned = true;
                        }
                    }
                    if (!returned) System.out.println("❌ Book not found.");
                    break;

                case 6:
                    running = false;
                    System.out.println("👋 Exiting Library System.");
                    break;

                default:
                    System.out.println("❌ Invalid option.");
            }
        }

        sc.close();
    }
}
