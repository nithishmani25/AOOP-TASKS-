import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

class Employee {
    private String name;
    private int age;
    private int experience; // in years

    public Employee(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", experience=" + experience + " years}";
    }
}

class CoffeeShop {
    private List<Employee> employees;

    public CoffeeShop() {
        employees = new ArrayList<>();
    }

    // Add an employee to the coffee shop
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Sort employees by experience (descending order)
    public void sortEmployeesByExperience() {
        employees.sort(Comparator.comparingInt(Employee::getExperience).reversed());
    }

    // Use Predicate to filter employees with experience > 2 years for bonus eligibility
    public List<Employee> getEmployeesEligibleForBonus() {
        Predicate<Employee> experienceFilter = employee -> employee.getExperience() > 2;
        List<Employee> eligibleEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (experienceFilter.test(employee)) {
                eligibleEmployees.add(employee);
            }
        }
        return eligibleEmployees;
    }

    // Distribute salaries and bonuses
    public void distributeSalariesAndBonuses(double baseSalary) {
        sortEmployeesByExperience(); // Sort employees by experience (more experienced first)

        System.out.println("Employees in queue (sorted by experience, most experienced first):");
        for (Employee employee : employees) {
            double bonus = 0;
            if (employee.getExperience() > 2) {
                bonus = baseSalary * 0.1; // 10% bonus for experience > 2 years
            }
            double totalCompensation = baseSalary + bonus;
            System.out.printf("Name: %s, Experience: %d years, Salary: $%.2f, Bonus: $%.2f, Total: $%.2f%n",
                    employee.getName(), employee.getExperience(), baseSalary, bonus, totalCompensation);
        }
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees); // Return a copy to prevent external modification
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a coffee shop
        CoffeeShop coffeeShop = new CoffeeShop();

        // Add employees with their details (name, age, experience)
        coffeeShop.addEmployee(new Employee("Employee1", 30, 5)); // 5 years experience
        coffeeShop.addEmployee(new Employee("Employee2", 28, 4)); // 4 years experience
        coffeeShop.addEmployee(new Employee("Employee3", 25, 3)); // 3 years experience
        coffeeShop.addEmployee(new Employee("Employee4", 23, 1)); // 1 year experience
        coffeeShop.addEmployee(new Employee("Employee5", 22, 0)); // Fresher (0 years experience)

        // Set a base salary (e.g., $2000 per month)
        double baseSalary = 2000.0;

        // Distribute salaries and bonuses
        System.out.println("Distributing salaries and bonuses for the coffee shop employees:");
        coffeeShop.distributeSalariesAndBonuses(baseSalary);

        // Use Predicate to filter and display employees eligible for bonus (experience > 2 years)
        System.out.println("\nEmployees eligible for bonus (experience > 2 years):");
        List<Employee> eligibleForBonus = coffeeShop.getEmployeesEligibleForBonus();
        for (Employee employee : eligibleForBonus) {
            System.out.println(employee);
        }
    }
}