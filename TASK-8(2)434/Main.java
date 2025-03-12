import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class StudentGradeManager {
    private Map<Integer, Double> studentGrades;  // Map to store student ID (key) and grade (value)
    private Set<Integer> studentIds;            // Set to ensure unique student IDs

    // Constructor
    public StudentGradeManager() {
        studentGrades = new HashMap<>();
        studentIds = new HashSet<>();
    }

    // Add or update a student's grade
    public void addGrade(int studentId, double grade) {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID cannot be negative");
        }
        if (grade < 0.0 || grade > 100.0) {
            throw new IllegalArgumentException("Grade must be between 0.0 and 100.0");
        }

        studentIds.add(studentId);  // Ensure unique ID (though Map handles this, Set provides O(1) lookup)
        studentGrades.put(studentId, grade);
    }

    // Retrieve a student's grade by ID
    public Double getGrade(int studentId) {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID cannot be negative");
        }
        Double grade = studentGrades.get(studentId);
        if (grade == null) {
            throw new IllegalArgumentException("Student ID not found");
        }
        return grade;
    }

    // Check if a student exists
    public boolean studentExists(int studentId) {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID cannot be negative");
        }
        return studentIds.contains(studentId);
    }

    // Get all student grades
    public Map<Integer, Double> getAllGrades() {
        return new HashMap<>(studentGrades);  // Return a copy to prevent external modification
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new StudentGradeManager instance
        StudentGradeManager gradeManager = new StudentGradeManager();

        // Demonstrate adding student grades
        try {
            gradeManager.addGrade(1001, 85.5);  // Add grade for student ID 1001
            gradeManager.addGrade(1002, 92.0);  // Add grade for student ID 1002
            gradeManager.addGrade(1003, 78.5);  // Add grade for student ID 1003

            System.out.println("All student grades:");
            Map<Integer, Double> allGrades = gradeManager.getAllGrades();
            for (Map.Entry<Integer, Double> entry : allGrades.entrySet()) {
                System.out.println("Student ID: " + entry.getKey() + ", Grade: " + entry.getValue());
            }

            // Demonstrate retrieving a specific student's grade
            System.out.println("\nGrade for student ID 1002: " + gradeManager.getGrade(1002));

            // Demonstrate checking if a student exists
            System.out.println("Does student ID 1001 exist? " + gradeManager.studentExists(1001));
            System.out.println("Does student ID 1004 exist? " + gradeManager.studentExists(1004));

            // Demonstrate error handling for invalid grade
            gradeManager.addGrade(1004, 101.0);  // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}