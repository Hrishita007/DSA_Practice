//Example of a simple Employee Management System in Java using OOP concepts,
//  Collections, Streams, and Exception Handling.
import java.util.*;
import java.util.stream.Collectors;

// ============================================================
// ENUM
// ============================================================

enum Department {
    IT,
    HR,
    FINANCE,
    SALES
}

// ============================================================
// CUSTOM EXCEPTION
// ============================================================

class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

// ============================================================
// EMPLOYEE CLASS
// ============================================================

class Employee {

    private int id;
    private String name;
    private Department department;
    private double salary;

    public Employee(int id, String name, Department department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    // Important when using Set / HashMap
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Employee employee = (Employee) obj;

        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// ============================================================
// INTERFACE
// ============================================================

interface EmployeeOperations {

    void addEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee findById(int id);

    List<Employee> getAllEmployees();
}

// ============================================================
// SERVICE CLASS
// ============================================================

class EmployeeService implements EmployeeOperations {

    // HashMap gives fast lookup using employee ID
    private final Map<Integer, Employee> employees = new HashMap<>();

    // ========================================================
    // CREATE
    // ========================================================

    @Override
    public void addEmployee(Employee employee) {

        if (employees.containsKey(employee.getId())) {
            System.out.println(
                    "Employee ID already exists: " + employee.getId());
            return;
        }

        employees.put(employee.getId(), employee);

        System.out.println(
                "Employee added successfully: " + employee.getName());
    }

    // ========================================================
    // READ ALL
    // ========================================================

    @Override
    public List<Employee> getAllEmployees() {

        return new ArrayList<>(employees.values());
    }

    // ========================================================
    // FIND BY ID
    // ========================================================

    @Override
    public Employee findById(int id) {

        return Optional.ofNullable(employees.get(id))
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with ID " + id + " not found"));
    }

    // ========================================================
    // UPDATE
    // ========================================================

    public void updateSalary(int id, double newSalary) {

        Employee employee = findById(id);

        employee.setSalary(newSalary);

        System.out.println(
                "Salary updated successfully.");
    }

    public void updateDepartment(int id, Department department) {

        Employee employee = findById(id);

        employee.setDepartment(department);

        System.out.println(
                "Department updated successfully.");
    }

    // ========================================================
    // DELETE
    // ========================================================

    @Override
    public void deleteEmployee(int id) {

        Employee employee = findById(id);

        employees.remove(id);

        System.out.println(
                "Deleted: " + employee.getName());
    }

    // ========================================================
    // SEARCH BY NAME
    // ========================================================

    public List<Employee> searchByName(String name) {

        return employees.values()
                .stream()
                .filter(e ->
                        e.getName()
                                .toLowerCase()
                                .contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // ========================================================
    // FILTER BY DEPARTMENT
    // ========================================================

    public List<Employee> getByDepartment(
            Department department) {

        return employees.values()
                .stream()
                .filter(e ->
                        e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    // ========================================================
    // SALARY GREATER THAN
    // ========================================================

    public List<Employee> getEmployeesAboveSalary(
            double salary) {

        return employees.values()
                .stream()
                .filter(e -> e.getSalary() > salary)
                .collect(Collectors.toList());
    }

    // ========================================================
    // SORT BY SALARY ASCENDING
    // ========================================================

    public List<Employee> sortBySalaryAscending() {

        return employees.values()
                .stream()
                .sorted(
                        Comparator.comparingDouble(
                                Employee::getSalary))
                .collect(Collectors.toList());
    }

    // ========================================================
    // SORT BY SALARY DESCENDING
    // ========================================================

    public List<Employee> sortBySalaryDescending() {

        return employees.values()
                .stream()
                .sorted(
                        Comparator.comparingDouble(
                                Employee::getSalary)
                                .reversed())
                .collect(Collectors.toList());
    }

    // ========================================================
    // SORT BY NAME
    // ========================================================

    public List<Employee> sortByName() {

        return employees.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Employee::getName))
                .collect(Collectors.toList());
    }

    // ========================================================
    // HIGHEST SALARY
    // ========================================================

    public Employee getHighestPaidEmployee() {

        return employees.values()
                .stream()
                .max(
                        Comparator.comparingDouble(
                                Employee::getSalary))
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "No employees available"));
    }

    // ========================================================
    // LOWEST SALARY
    // ========================================================

    public Employee getLowestPaidEmployee() {

        return employees.values()
                .stream()
                .min(
                        Comparator.comparingDouble(
                                Employee::getSalary))
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "No employees available"));
    }

    // ========================================================
    // SECOND HIGHEST SALARY
    // ========================================================

    public Optional<Employee> getSecondHighestPaidEmployee() {

        return employees.values()
                .stream()
                .sorted(
                        Comparator.comparingDouble(
                                Employee::getSalary)
                                .reversed())
                .skip(1)
                .findFirst();
    }

    // ========================================================
    // AVERAGE SALARY
    // ========================================================

    public double getAverageSalary() {

        return employees.values()
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    // ========================================================
    // TOTAL SALARY
    // ========================================================

    public double getTotalSalary() {

        return employees.values()
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    // ========================================================
    // COUNT EMPLOYEES
    // ========================================================

    public long getEmployeeCount() {

        return employees.size();
    }

    // ========================================================
    // COUNT BY DEPARTMENT
    // ========================================================

    public Map<Department, Long> countByDepartment() {

        return employees.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()));
    }

    // ========================================================
    // HIGHEST SALARY BY DEPARTMENT
    // ========================================================

    public Map<Department, Optional<Employee>>
    highestPaidByDepartment() {

        return employees.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(
                                                Employee::getSalary))));
    }

    // ========================================================
    // EMPLOYEES WITH SALARY RANGE
    // ========================================================

    public List<Employee> salaryBetween(
            double minimum,
            double maximum) {

        return employees.values()
                .stream()
                .filter(e ->
                        e.getSalary() >= minimum &&
                        e.getSalary() <= maximum)
                .collect(Collectors.toList());
    }
}

// ============================================================
// MAIN CLASS
// ============================================================

public class Main {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        // ====================================================
        // ADD EMPLOYEES
        // ====================================================

        service.addEmployee(
                new Employee(
                        1,
                        "Rahul",
                        Department.IT,
                        75000));

        service.addEmployee(
                new Employee(
                        2,
                        "Priya",
                        Department.HR,
                        55000));

        service.addEmployee(
                new Employee(
                        3,
                        "Arun",
                        Department.IT,
                        90000));

        service.addEmployee(
                new Employee(
                        4,
                        "Sneha",
                        Department.FINANCE,
                        80000));

        service.addEmployee(
                new Employee(
                        5,
                        "Vijay",
                        Department.SALES,
                        65000));

        service.addEmployee(
                new Employee(
                        6,
                        "Anita",
                        Department.IT,
                        95000));

        System.out.println("\n=================================");
        System.out.println("ALL EMPLOYEES");
        System.out.println("=================================");

        service.getAllEmployees()
                .forEach(System.out::println);

        // ====================================================
        // FIND EMPLOYEE
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("FIND EMPLOYEE");
        System.out.println("=================================");

        try {

            Employee employee = service.findById(3);

            System.out.println(employee);

        } catch (EmployeeNotFoundException e) {

            System.out.println(e.getMessage());
        }

        // ====================================================
        // SEARCH BY NAME
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("SEARCH BY NAME");
        System.out.println("=================================");

        service.searchByName("an")
                .forEach(System.out::println);

        // ====================================================
        // IT EMPLOYEES
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("IT EMPLOYEES");
        System.out.println("=================================");

        service.getByDepartment(Department.IT)
                .forEach(System.out::println);

        // ====================================================
        // SALARY ABOVE 70000
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("SALARY ABOVE 70000");
        System.out.println("=================================");

        service.getEmployeesAboveSalary(70000)
                .forEach(System.out::println);

        // ====================================================
        // SORT BY SALARY
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("SALARY ASCENDING");
        System.out.println("=================================");

        service.sortBySalaryAscending()
                .forEach(System.out::println);

        System.out.println("\n=================================");
        System.out.println("SALARY DESCENDING");
        System.out.println("=================================");

        service.sortBySalaryDescending()
                .forEach(System.out::println);

        // ====================================================
        // SORT BY NAME
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("SORT BY NAME");
        System.out.println("=================================");

        service.sortByName()
                .forEach(System.out::println);

        // ====================================================
        // HIGHEST SALARY
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("HIGHEST SALARY");
        System.out.println("=================================");

        System.out.println(
                service.getHighestPaidEmployee());

        // ====================================================
        // LOWEST SALARY
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("LOWEST SALARY");
        System.out.println("=================================");

        System.out.println(
                service.getLowestPaidEmployee());

        // ====================================================
        // SECOND HIGHEST SALARY
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("SECOND HIGHEST SALARY");
        System.out.println("=================================");

        service.getSecondHighestPaidEmployee()
                .ifPresent(System.out::println);

        // ====================================================
        // AVERAGE SALARY
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("AVERAGE SALARY");
        System.out.println("=================================");

        System.out.println(
                service.getAverageSalary());

        // ====================================================
        // TOTAL SALARY
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("TOTAL SALARY");
        System.out.println("=================================");

        System.out.println(
                service.getTotalSalary());

        // ====================================================
        // EMPLOYEE COUNT
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("EMPLOYEE COUNT");
        System.out.println("=================================");

        System.out.println(
                service.getEmployeeCount());

        // ====================================================
        // COUNT BY DEPARTMENT
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("COUNT BY DEPARTMENT");
        System.out.println("=================================");

        service.countByDepartment()
                .forEach(
                        (department, count) ->
                                System.out.println(
                                        department +
                                        " -> " +
                                        count));

        // ====================================================
        // HIGHEST PAID BY DEPARTMENT
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("HIGHEST PAID BY DEPARTMENT");
        System.out.println("=================================");

        service.highestPaidByDepartment()
                .forEach(
                        (department, employee) ->
                                System.out.println(
                                        department +
                                        " -> " +
                                        employee.orElse(null)));

        // ====================================================
        // SALARY RANGE
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("SALARY BETWEEN 60000 AND 90000");
        System.out.println("=================================");

        service.salaryBetween(60000, 90000)
                .forEach(System.out::println);

        // ====================================================
        // UPDATE
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("UPDATE SALARY");
        System.out.println("=================================");

        service.updateSalary(1, 85000);

        System.out.println(
                service.findById(1));

        // ====================================================
        // UPDATE DEPARTMENT
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("UPDATE DEPARTMENT");
        System.out.println("=================================");

        service.updateDepartment(
                2,
                Department.IT);

        System.out.println(
                service.findById(2));

        // ====================================================
        // DELETE
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("DELETE EMPLOYEE");
        System.out.println("=================================");

        service.deleteEmployee(5);

        System.out.println("\nEmployees after deletion:");

        service.getAllEmployees()
                .forEach(System.out::println);

        // ====================================================
        // OPTIONAL EXCEPTION TEST
        // ====================================================

        System.out.println("\n=================================");
        System.out.println("EXCEPTION HANDLING");
        System.out.println("=================================");

        try {

            service.findById(100);

        } catch (EmployeeNotFoundException e) {

            System.out.println(
                    "Exception caught: " +
                    e.getMessage());
        }
    }
}