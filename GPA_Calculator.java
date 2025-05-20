import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// GPA Calculator Class
public class GPA_Calculator {
    private List<Course> courses;

    public GPA_Calculator() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseCode, int credits, String grade) {
        this.courses.add(new Course(courseCode, credits, grade));
    }

    public double calculateGPA() {
        if (courses.isEmpty()) {
            return 0.0;
        }

        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Course course : courses) {
            double gradePoint = getGradePoint(course.getGrade());
            totalGradePoints += gradePoint * course.getCredits();
            totalCredits += course.getCredits();
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return totalGradePoints / totalCredits;
    }

    private double getGradePoint(String grade) {
        switch (grade.toUpperCase()) {
            case "A":
                return 4.0;
            case "B+":
                return 3.5;
            case "B":
                return 3.0;
            case "C+":
                return 2.5;
            case "C":
                return 2.0;
            case "D+":
                return 1.5;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0; // Or handle invalid grades differently
        }
    }

    private static class Course {
        private String courseCode;
        private int credits;
        private String grade;

        public Course(String courseCode, int credits, String grade) {
            this.courseCode = courseCode;
            this.credits = credits;
            this.grade = grade;
        }

        public int getCredits() {
            return credits;
        }

        public String getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GPA_Calculator calculator = new GPA_Calculator();

        System.out.println("--- GPA Calculator ---");

        boolean addingCourses = true;
        while (addingCourses) {
            System.out.print("Enter Course Code (or 'done' to calculate): ");
            String courseCode = scanner.nextLine();
            if (courseCode.equalsIgnoreCase("done")) {
                addingCourses = false;
                break;
            }

            System.out.print("Enter Credits for " + courseCode + ": ");
            int credits = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Grade for " + courseCode + " (e.g., A, B+, C): ");
            String grade = scanner.nextLine();

            calculator.addCourse(courseCode, credits, grade);
        }

        System.out.println("\nYour GPA: " + String.format("%.2f", calculator.calculateGPA()));
        scanner.close();
    }
}


