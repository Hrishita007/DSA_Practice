//Employee Management System using Java Streams
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    // Add employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Find employee by ID
    public Employee findById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Employee not found"));
    }

    // Get employees by department
    public List<Employee> getByDepartment(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    // Find employees earning more than a given salary
    public List<Employee> getEmployeesAboveSalary(double salary) {
        return employees.stream()
                .filter(e -> e.getSalary() > salary)
                .collect(Collectors.toList());
    }

    // Sort employees by salary
    public List<Employee> sortBySalary() {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }

    // Find highest-paid employee
    public Employee getHighestPaidEmployee() {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() ->
                        new NoSuchElementException("No employees available"));
    }
}

public class EmployeeMgmt {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        service.addEmployee(
                new Employee(1, "Rahul", "IT", 75000));

        service.addEmployee(
                new Employee(2, "Priya", "HR", 55000));

        service.addEmployee(
                new Employee(3, "Arun", "IT", 90000));

        service.addEmployee(
                new Employee(4, "Sneha", "Finance", 80000));

        System.out.println("Employee with ID 3:");
        System.out.println(service.findById(3));

        System.out.println("\nIT Employees:");
        service.getByDepartment("IT")
                .forEach(System.out::println);

        System.out.println("\nEmployees earning above 70000:");
        service.getEmployeesAboveSalary(70000)
                .forEach(System.out::println);

        System.out.println("\nEmployees sorted by salary:");
        service.sortBySalary()
                .forEach(System.out::println);

        System.out.println("\nHighest paid employee:");
        System.out.println(service.getHighestPaidEmployee());
    }
}