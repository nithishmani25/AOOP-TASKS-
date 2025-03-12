package com.company.employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Add employee objects to the list
        employees.add(new Employee(1, "John", "HR", 50000));
        employees.add(new Employee(2, "Alice", "Finance", 60000));
        employees.add(new Employee(3, "Bob", "Engineering", 55000));
        employees.add(new Employee(4, "David", "HR", 47000));
        employees.add(new Employee(5, "Charlie", "Engineering", 70000));

        // Sort by salary (ascending)
        System.out.println("Sorting by Salary (Ascending):");
        Collections.sort(employees, EmployeeComparators.sortBySalaryAsc);
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Sort by salary (descending)
        System.out.println("\nSorting by Salary (Descending):");
        Collections.sort(employees, EmployeeComparators.sortBySalaryDesc);
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Sort by name (alphabetical order)
        System.out.println("\nSorting by Name (Alphabetical Order):");
        Collections.sort(employees, EmployeeComparators.sortByName);
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Sort by department (alphabetical order)
        System.out.println("\nSorting by Department (Alphabetical Order):");
        Collections.sort(employees, EmployeeComparators.sortByDepartment);
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

