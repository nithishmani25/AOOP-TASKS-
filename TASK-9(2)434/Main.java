import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", department='" + department + 
               "', salary=" + salary + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice Johnson", 30, "Engineering", 75000.0),
            new Employee("Bob Smith", 35, "Marketing", 65000.0),
            new Employee("Charlie Brown", 28, "Engineering", 80000.0),
            new Employee("David Lee", 40, "HR", 60000.0),
            new Employee("Eve Davis", 32, "Marketing", 70000.0)
        );

        // 1. Filtering employees by Department (e.g., Engineering)
        System.out.println("Employees in Engineering Department:");
        List<Employee> engineeringEmployees = employees.stream()
                .filter(employee -> "Engineering".equals(employee.getDepartment()))
                .collect(Collectors.toList());
        engineeringEmployees.forEach(System.out::println);

        // 2. Sort employees by their names
        System.out.println("\nEmployees sorted by name:");
        List<Employee> sortedByName = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        sortedByName.forEach(System.out::println);

        // 3. Find the employee with the highest salary
        System.out.println("\nEmployee with the highest salary:");
        Employee highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("No employees found"));
        System.out.println(highestPaid);

        // 4. Calculate average salary of employees
        System.out.println("\nAverage salary of all employees:");
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(() -> new RuntimeException("No employees found"));
        System.out.printf("Average Salary: $%.2f%n", averageSalary);
    }
}