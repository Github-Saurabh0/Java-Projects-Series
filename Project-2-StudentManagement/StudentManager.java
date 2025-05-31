import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("✅ Student added successfully!\n");
    }

    public void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("⚠️ No student records found.\n");
            return;
        }

        System.out.println("\n📋 List of Students:");
        for (Student s : studentList) {
            System.out.println(s);
        }
        System.out.println();
    }

    public void searchStudent(int rollNumber) {
        for (Student s : studentList) {
            if (s.getRollNumber() == rollNumber) {
                System.out.println("🔍 Found: " + s + "\n");
                return;
            }
        }
        System.out.println("❌ Student with Roll No " + rollNumber + " not found.\n");
    }

    public void deleteStudent(int rollNumber) {
        for (Student s : studentList) {
            if (s.getRollNumber() == rollNumber) {
                studentList.remove(s);
                System.out.println("🗑️ Student deleted successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student with Roll No " + rollNumber + " not found.\n");
    }
}
