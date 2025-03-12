package com.company.employees;
import java.util.Comparator;
public class EmployeeComparators {
    // Comparator for sorting by salary (ascending)
    public static Comparator<Employee> sortBySalaryAsc = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.getSalary(), e2.getSalary());
        }
    };

    // Comparator for sorting by salary (descending)
    public static Comparator<Employee> sortBySalaryDesc = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e2.getSalary(), e1.getSalary());
        }
    };

    // Comparator for sorting by name (alphabetical order)
    public static Comparator<Employee> sortByName = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    // Comparator for sorting by department (alphabetical order)
    public static Comparator<Employee> sortByDepartment = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getDepartment().compareTo(e2.getDepartment());
        }
    };
}
