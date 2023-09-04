import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeSorter {
    public static void main(String[] args) {
        // Define the employee data as a list of dictionaries
        List<Employee> employeeData = new ArrayList<>();
        employeeData.add(new Employee("161E90", "Raman", 41, 56000));
        employeeData.add(new Employee("161F91", "Himadri", 38, 67500));
        employeeData.add(new Employee("161F99", "Jaya", 51, 82100));
        employeeData.add(new Employee("171E20", "Tejas", 30, 55000));
        employeeData.add(new Employee("171G30", "Ajay", 45, 44000));

        // Input from the user to select sorting parameter
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a sorting parameter:");
        System.out.println("1. Age");
        System.out.println("2. Name");
        System.out.println("3. Salary");
        int sortParam = scanner.nextInt();

        // Sort the data based on the selected parameter
        List<Employee> sortedEmployeeData = sortEmployeeData(employeeData, sortParam);

        // Print the sorted data
        System.out.println("\nSorted Employee Data:");
        for (Employee employee : sortedEmployeeData) {
            System.out.println("Employee ID: " + employee.getEmployeeID() +
                    ", Name: " + employee.getName() +
                    ", Age: " + employee.getAge() +
                    ", Salary (PM): " + employee.getSalary());
        }
    }

    // Employee class to represent each employee
    static class Employee {
        private String employeeID;
        private String name;
        private int age;
        private int salary;

        public Employee(String employeeID, String name, int age, int salary) {
            this.employeeID = employeeID;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getEmployeeID() {
            return employeeID;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getSalary() {
            return salary;
        }
    }

    // Function to sort employee data based on the selected parameter
    public static List<Employee> sortEmployeeData(List<Employee> data, int sortParam) {
        if (sortParam == 1) {
            Collections.sort(data, Comparator.comparing(Employee::getAge));
        } else if (sortParam == 2) {
            Collections.sort(data, Comparator.comparing(Employee::getName));
        } else if (sortParam == 3) {
            Collections.sort(data, Comparator.comparing(Employee::getSalary));
        }
        return data;
    }
}
