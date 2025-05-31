public class Student {
    private int rollNumber;
    private String name;
    private String course;

    public Student(int rollNumber, String name, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Course: " + course;
    }
}
