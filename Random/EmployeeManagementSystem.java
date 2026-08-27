import java.util.*;
import java.util.stream.Collectors;

// ============================================================
// 1. ENUM
// ============================================================

// ENUM:
// Used when we have a fixed set of constant values.
// Here an employee can belong to one of these departments.
enum Department {
    IT,
    HR,
    FINANCE,
    SALES
}


// ============================================================
// 2. CUSTOM EXCEPTION
// ============================================================

// INHERITANCE:
// EmployeeNotFoundException IS-A RuntimeException.
//
// We are creating our own exception by extending
// the existing RuntimeException class.
class EmployeeNotFoundException extends RuntimeException {

    // CONSTRUCTOR
    public EmployeeNotFoundException(String message) {

        // super() calls the constructor of the parent class.
        super(message);
    }
}


// ============================================================
// 3. EMPLOYEE CLASS
// ============================================================

// CLASS:
// A class is a blueprint for creating objects.
//
// Example:
// Employee e1 = new Employee(...);
//
// Employee = class
// e1       = object/reference
class Employee {

    // ========================================================
    // ENCAPSULATION
    // ========================================================

    // private:
    // These variables cannot be directly accessed from outside
    // the Employee class.
    //
    // This is DATA HIDING / ENCAPSULATION.
    private int id;
    private String name;
    private Department department;
    private double salary;


    // ========================================================
    // CONSTRUCTOR
    // ========================================================

    // Constructor is automatically called when we use "new".
    public Employee(int id,
                    String name,
                    Department department,
                    double salary) {

        // "this" refers to the current object.
        //
        // this.id = id
        // left side  -> object variable
        // right side -> constructor parameter

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    // ========================================================
    // GETTERS
    // ========================================================

    // GETTER:
    // Provides controlled access to private variables.

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


    // ========================================================
    // SETTERS
    // ========================================================

    // SETTER:
    // Allows controlled modification of private variables.

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // ========================================================
    // toString()
    // ========================================================

    // METHOD OVERRIDING:
    //
    // Object class already contains toString().
    // We override it to print Employee information
    // in our own format.

    @Override
    public String toString() {

        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }


    // ========================================================
    // equals()
    // ========================================================

    // METHOD OVERRIDING:
    //
    // Object class has equals().
    // We override it to decide when two Employee objects
    // should be considered equal.

    @Override
    public boolean equals(Object obj) {

        // If both references point to the exact same object.
        if (this == obj) {
            return true;
        }


        // If obj is null OR is not an Employee object.
        if (obj == null ||
                getClass() != obj.getClass()) {

            return false;
        }


        // TYPE CASTING:
        //
        // Convert Object reference into Employee reference.
        Employee employee = (Employee) obj;


        // Two employees are considered equal
        // if their IDs are equal.
        return id == employee.id;
    }


    // ========================================================
    // hashCode()
    // ========================================================

    // METHOD OVERRIDING:
    //
    // hashCode() comes from Object class.
    //
    // Important when using HashMap, HashSet, etc.

    @Override
    public int hashCode() {

        // Objects.hash() creates hash value based on ID.
        return Objects.hash(id);
    }
}


// ============================================================
// 4. INTERFACE
// ============================================================

// ABSTRACTION:
//
// Interface defines WHAT operations the service should provide.
//
// It does not provide the implementation here.
//
// This is one of the main OOP concepts: ABSTRACTION.
interface EmployeeOperations {

    void addEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee findById(int id);

    List<Employee> getAllEmployees();
}


// ============================================================
// 5. SERVICE CLASS
// ============================================================

// IMPLEMENTS:
//
// EmployeeService implements EmployeeOperations.
//
// Therefore EmployeeService must provide implementations
// for all abstract methods from the interface.
//
// This demonstrates ABSTRACTION + POLYMORPHISM.
class EmployeeService implements EmployeeOperations {


    // ========================================================
    // HASHMAP
    // ========================================================

    // COLLECTION:
    //
    // Key   = Employee ID
    // Value = Employee object
    //
    // HashMap provides fast lookup using employee ID.

    private final Map<Integer, Employee> employees =
            new HashMap<>();


    // ========================================================
    // ADD EMPLOYEE
    // ========================================================

    // @Override:
    // This method is implemented from EmployeeOperations.

    @Override
    public void addEmployee(Employee employee) {

        // containsKey():
        // Checks whether this employee ID already exists.

        if (employees.containsKey(employee.getId())) {

            System.out.println(
                    "Employee ID already exists: "
                            + employee.getId());

            return;
        }


        // HashMap put():
        //
        // Stores:
        // employee ID -> Employee object

        employees.put(
                employee.getId(),
                employee);

        System.out.println(
                "Employee added: "
                        + employee.getName());
    }


    // ========================================================
    // FIND EMPLOYEE BY ID
    // ========================================================

    @Override
    public Employee findById(int id) {

        // HashMap get():
        // Searches employee using the ID.

        return Optional
                .ofNullable(employees.get(id))

                // OPTIONAL:
                //
                // If employee exists -> return employee.
                // If employee doesn't exist -> throw exception.

                .orElseThrow(
                        () -> new EmployeeNotFoundException(
                                "Employee not found: " + id));
    }


    // ========================================================
    // GET ALL EMPLOYEES
    // ========================================================

    @Override
    public List<Employee> getAllEmployees() {

        // employees.values():
        // Gets all Employee objects from HashMap.

        // new ArrayList<>():
        // Converts collection into a List.

        return new ArrayList<>(
                employees.values());
    }


    // ========================================================
    // UPDATE SALARY
    // ========================================================

    public void updateSalary(
            int id,
            double newSalary) {

        // First find the employee.
        //
        // If employee doesn't exist,
        // findById() throws an exception.

        Employee employee =
                findById(id);


        // ENCAPSULATION:
        //
        // We don't write:
        //
        // employee.salary = newSalary;
        //
        // because salary is private.
        //
        // We use the setter instead.

        employee.setSalary(newSalary);

        System.out.println(
                "Salary updated.");
    }


    // ========================================================
    // UPDATE DEPARTMENT
    // ========================================================

    public void updateDepartment(
            int id,
            Department department) {

        Employee employee =
                findById(id);

        employee.setDepartment(department);

        System.out.println(
                "Department updated.");
    }


    // ========================================================
    // DELETE EMPLOYEE
    // ========================================================

    @Override
    public void deleteEmployee(int id) {

        // Check whether employee exists.
        findById(id);


        // HashMap remove():
        // Deletes the employee using the ID.

        employees.remove(id);

        System.out.println(
                "Employee deleted.");
    }


    // ========================================================
    // SEARCH BY NAME
    // ========================================================

    public List<Employee> searchByName(
            String name) {

        return employees.values()

                // STREAM API:
                //
                // Converts collection into a Stream
                // so we can process the data.

                .stream()

                // FILTER:
                //
                // Keep only employees whose names
                // contain the search text.

                .filter(
                        employee ->
                                employee.getName()
                                        .toLowerCase()
                                        .contains(
                                                name.toLowerCase()))

                // COLLECT:
                //
                // Convert Stream back into a List.

                .collect(
                        Collectors.toList());
    }


    // ========================================================
    // GET EMPLOYEES BY DEPARTMENT
    // ========================================================

    public List<Employee> getByDepartment(
            Department department) {

        return employees.values()
                .stream()

                // LAMBDA EXPRESSION:
                //
                // employee -> condition
                //
                // This is a Java 8+ feature.

                .filter(
                        employee ->
                                employee.getDepartment()
                                        == department)

                .collect(
                        Collectors.toList());
    }


    // ========================================================
    // SALARY GREATER THAN
    // ========================================================

    public List<Employee> getEmployeesAboveSalary(
            double salary) {

        return employees.values()
                .stream()

                // FILTER:
                // Only employees whose salary is
                // greater than the given value.

                .filter(
                        employee ->
                                employee.getSalary()
                                        > salary)

                .collect(
                        Collectors.toList());
    }


    // ========================================================
    // SORT BY SALARY ASCENDING
    // ========================================================

    public List<Employee> sortBySalaryAscending() {

        return employees.values()
                .stream()

                // SORTING:
                //
                // Comparator is used to tell Java
                // how Employee objects should be compared.

                .sorted(
                        Comparator.comparingDouble(
                                Employee::getSalary))

                .collect(
                        Collectors.toList());
    }


    // ========================================================
    // SORT BY SALARY DESCENDING
    // ========================================================

    public List<Employee> sortBySalaryDescending() {

        return employees.values()
                .stream()

                .sorted(

                        // METHOD REFERENCE:
                        //
                        // Employee::getSalary
                        //
                        // Same idea as:
                        // employee -> employee.getSalary()

                        Comparator.comparingDouble(
                                Employee::getSalary)

                                // REVERSED:
                                // Highest salary first.

                                .reversed())

                .collect(
                        Collectors.toList());
    }


    // ========================================================
    // SORT BY NAME
    // ========================================================

    public List<Employee> sortByName() {

        return employees.values()
                .stream()

                .sorted(

                        // Comparator compares employee names.

                        Comparator.comparing(
                                Employee::getName))

                .collect(
                        Collectors.toList());
    }


    // ========================================================
    // HIGHEST PAID EMPLOYEE
    // ========================================================

    public Employee getHighestPaidEmployee() {

        return employees.values()
                .stream()

                // MAX:
                // Finds employee with highest salary.

                .max(
                        Comparator.comparingDouble(
                                Employee::getSalary))

                // OPTIONAL:
                // max() returns Optional<Employee>.

                .orElseThrow(
                        () ->
                                new EmployeeNotFoundException(
                                        "No employees found"));
    }


    // ========================================================
    // LOWEST PAID EMPLOYEE
    // ========================================================

    public Employee getLowestPaidEmployee() {

        return employees.values()
                .stream()

                // MIN:
                // Finds employee with lowest salary.

                .min(
                        Comparator.comparingDouble(
                                Employee::getSalary))

                .orElseThrow(
                        () ->
                                new EmployeeNotFoundException(
                                        "No employees found"));
    }


    // ========================================================
    // SECOND HIGHEST SALARY
    // ========================================================

    public Optional<Employee>
    getSecondHighestPaidEmployee() {

        return employees.values()
                .stream()

                // SORT salary in descending order.

                .sorted(
                        Comparator.comparingDouble(
                                Employee::getSalary)
                                .reversed())

                // SKIP:
                //
                // Skip the highest-paid employee.

                .skip(1)

                // FIND FIRST:
                //
                // The next employee becomes
                // the second-highest.

                .findFirst();
    }


    // ========================================================
    // AVERAGE SALARY
    // ========================================================

    public double getAverageSalary() {

        return employees.values()
                .stream()

                // mapToDouble():
                //
                // Convert Employee objects into
                // their salary values.

                .mapToDouble(
                        Employee::getSalary)

                // AVERAGE:
                //
                // Calculate average salary.

                .average()

                // If no employee exists,
                // return 0.

                .orElse(0);
    }


    // ========================================================
    // TOTAL SALARY
    // ========================================================

    public double getTotalSalary() {

        return employees.values()
                .stream()

                .mapToDouble(
                        Employee::getSalary)

                // SUM:
                // Add all employee salaries.

                .sum();
    }


    // ========================================================
    // EMPLOYEE COUNT
    // ========================================================

    public long getEmployeeCount() {

        // HashMap size():
        // Number of employees stored in the Map.

        return employees.size();
    }


    // ========================================================
    // COUNT EMPLOYEES BY DEPARTMENT
    // ========================================================

    public Map<Department, Long>
    countByDepartment() {

        return employees.values()
                .stream()

                // COLLECTORS:
                //
                // groupingBy() groups employees
                // according to their department.

                .collect(
                        Collectors.groupingBy(

                                Employee::getDepartment,

                                // COUNT:
                                //
                                // Count employees inside
                                // each department.

                                Collectors.counting()));
    }


    // ========================================================
    // HIGHEST PAID EMPLOYEE IN EACH DEPARTMENT
    // ========================================================

    public Map<Department, Optional<Employee>>
    highestPaidByDepartment() {

        return employees.values()
                .stream()

                .collect(

                        // GROUPING:
                        //
                        // First group employees by department.

                        Collectors.groupingBy(

                                Employee::getDepartment,

                                // MAX BY:
                                //
                                // Within each department,
                                // find employee with highest salary.

                                Collectors.maxBy(

                                        Comparator.comparingDouble(
                                                Employee::getSalary))));
    }


    // ========================================================
    // EMPLOYEES IN SALARY RANGE
    // ========================================================

    public List<Employee> salaryBetween(
            double minimum,
            double maximum) {

        return employees.values()
                .stream()

                .filter(
                        employee ->
                                employee.getSalary()
                                        >= minimum
                                        &&
                                employee.getSalary()
                                        <= maximum)

                .collect(
                        Collectors.toList());
    }
}


// ============================================================
// 6. MAIN CLASS
// ============================================================

public class EmployeeManagementSystem {

    public static void main(String[] args) {


        // ====================================================
        // OBJECT CREATION
        // ====================================================

        // new:
        //
        // Creates an Employee object in memory.

        Employee e1 =
                new Employee(
                        1,
                        "Rahul",
                        Department.IT,
                        75000);


        Employee e2 =
                new Employee(
                        2,
                        "Priya",
                        Department.HR,
                        55000);


        Employee e3 =
                new Employee(
                        3,
                        "Arun",
                        Department.IT,
                        90000);


        Employee e4 =
                new Employee(
                        4,
                        "Sneha",
                        Department.FINANCE,
                        80000);


        Employee e5 =
                new Employee(
                        5,
                        "Vijay",
                        Department.SALES,
                        65000);


        Employee e6 =
                new Employee(
                        6,
                        "Anita",
                        Department.IT,
                        95000);


        // ====================================================
        // POLYMORPHISM
        // ====================================================

        // INTERFACE REFERENCE:
        //
        // EmployeeOperations = interface
        // EmployeeService    = implementation
        //
        // We can store EmployeeService object
        // inside an EmployeeOperations reference.

        EmployeeOperations operations =
                new EmployeeService();


        // ====================================================
        // ADD EMPLOYEES
        // ====================================================

        operations.addEmployee(e1);
        operations.addEmployee(e2);
        operations.addEmployee(e3);
        operations.addEmployee(e4);
        operations.addEmployee(e5);
        operations.addEmployee(e6);


        // ====================================================
        // DOWNCASTING
        // ====================================================

        // operations is an EmployeeOperations reference.
        //
        // Some methods such as updateSalary()
        // are not defined in EmployeeOperations.
        //
        // Therefore we cast it back to EmployeeService.

        EmployeeService service =
                (EmployeeService) operations;


        // ====================================================
        // DISPLAY ALL
        // ====================================================

        System.out.println(
                "\n===== ALL EMPLOYEES =====");

        service.getAllEmployees()

                // METHOD REFERENCE:
                //
                // System.out::println
                //
                // Same idea as:
                //
                // employee ->
                //     System.out.println(employee)

                .forEach(
                        System.out::println);


        // ====================================================
        // FIND BY ID
        // ====================================================

        System.out.println(
                "\n===== FIND EMPLOYEE =====");

        try {

            System.out.println(
                    service.findById(3));

        } catch (
                EmployeeNotFoundException e) {

            // EXCEPTION HANDLING:
            // catch handles the exception.

            System.out.println(
                    "Error: " +
                            e.getMessage());
        }


        // ====================================================
        // SEARCH BY NAME
        // ====================================================

        System.out.println(
                "\n===== SEARCH NAME =====");

        service.searchByName("an")

                .forEach(
                        System.out::println);


        // ====================================================
        // IT DEPARTMENT
        // ====================================================

        System.out.println(
                "\n===== IT EMPLOYEES =====");

        service.getByDepartment(
                        Department.IT)

                .forEach(
                        System.out::println);


        // ====================================================
        // SALARY ABOVE 70000
        // ====================================================

        System.out.println(
                "\n===== SALARY ABOVE 70000 =====");

        service.getEmployeesAboveSalary(70000)

                .forEach(
                        System.out::println);


        // ====================================================
        // SORT ASCENDING
        // ====================================================

        System.out.println(
                "\n===== SALARY ASCENDING =====");

        service.sortBySalaryAscending()

                .forEach(
                        System.out::println);


        // ====================================================
        // SORT DESCENDING
        // ====================================================

        System.out.println(
                "\n===== SALARY DESCENDING =====");

        service.sortBySalaryDescending()

                .forEach(
                        System.out::println);


        // ====================================================
        // SORT BY NAME
        // ====================================================

        System.out.println(
                "\n===== SORT BY NAME =====");

        service.sortByName()

                .forEach(
                        System.out::println);


        // ====================================================
        // HIGHEST SALARY
        // ====================================================

        System.out.println(
                "\n===== HIGHEST PAID =====");

        System.out.println(
                service.getHighestPaidEmployee());


        // ====================================================
        // LOWEST SALARY
        // ====================================================

        System.out.println(
                "\n===== LOWEST PAID =====");

        System.out.println(
                service.getLowestPaidEmployee());


        // ====================================================
        // SECOND HIGHEST SALARY
        // ====================================================

        System.out.println(
                "\n===== SECOND HIGHEST =====");

        service.getSecondHighestPaidEmployee()

                // OPTIONAL:
                //
                // Employee may or may not exist.
                //
                // ifPresent() executes only if a value exists.

                .ifPresent(
                        System.out::println);


        // ====================================================
        // AVERAGE SALARY
        // ====================================================

        System.out.println(
                "\n===== AVERAGE SALARY =====");

        System.out.println(
                service.getAverageSalary());


        // ====================================================
        // TOTAL SALARY
        // ====================================================

        System.out.println(
                "\n===== TOTAL SALARY =====");

        System.out.println(
                service.getTotalSalary());


        // ====================================================
        // EMPLOYEE COUNT
        // ====================================================

        System.out.println(
                "\n===== EMPLOYEE COUNT =====");

        System.out.println(
                service.getEmployeeCount());


        // ====================================================
        // COUNT BY DEPARTMENT
        // ====================================================

        System.out.println(
                "\n===== COUNT BY DEPARTMENT =====");

        service.countByDepartment()

                // forEach with TWO parameters:
                //
                // department -> key
                // count      -> value

                .forEach(
                        (department, count) ->

                                System.out.println(
                                        department +
                                                " -> " +
                                                count));


        // ====================================================
        // HIGHEST PAID BY DEPARTMENT
        // ====================================================

        System.out.println(
                "\n===== HIGHEST PAID BY DEPARTMENT =====");

        service.highestPaidByDepartment()

                .forEach(
                        (department, employee) ->

                                System.out.println(
                                        department +
                                                " -> " +
                                                employee
                                                        .orElse(null)));


        // ====================================================
        // SALARY RANGE
        // ====================================================

        System.out.println(
                "\n===== SALARY 60000 - 90000 =====");

        service.salaryBetween(
                        60000,
                        90000)

                .forEach(
                        System.out::println);


        // ====================================================
        // UPDATE SALARY
        // ====================================================

        System.out.println(
                "\n===== UPDATE SALARY =====");

        service.updateSalary(
                1,
                85000);

        System.out.println(
                service.findById(1));


        // ====================================================
        // UPDATE DEPARTMENT
        // ====================================================

        System.out.println(
                "\n===== UPDATE DEPARTMENT =====");

        service.updateDepartment(
                2,
                Department.IT);

        System.out.println(
                service.findById(2));


        // ====================================================
        // DELETE
        // ====================================================

        System.out.println(
                "\n===== DELETE EMPLOYEE =====");

        service.deleteEmployee(5);


        // ====================================================
        // SHOW AFTER DELETE
        // ====================================================

        System.out.println(
                "\n===== AFTER DELETE =====");

        service.getAllEmployees()

                .forEach(
                        System.out::println);


        // ====================================================
        // EXCEPTION TEST
        // ====================================================

        System.out.println(
                "\n===== EXCEPTION TEST =====");

        try {

            // Employee 100 doesn't exist.

            service.findById(100);

        } catch (
                EmployeeNotFoundException e) {

            System.out.println(
                    "Exception caught: " +
                            e.getMessage());
        }
    }
}