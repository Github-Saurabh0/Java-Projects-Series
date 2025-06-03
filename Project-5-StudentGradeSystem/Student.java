public class Student {
    private String name;
    private int rollNo;
    private int[] marks;
    private int total;
    private double average;

    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        calculateTotalAndAverage();
    }

    private void calculateTotalAndAverage() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        average = (double) total / marks.length;
    }

    public void displayReportCard() {
        System.out.println("\n📝 Report Card");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + getGrade());
    }

    private String getGrade() {
        if (average >= 90) return "A+";
        else if (average >= 75) return "A";
        else if (average >= 60) return "B";
        else if (average >= 40) return "C";
        else return "F (Fail)";
    }
}
