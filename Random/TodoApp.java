import java.io.*;
import java.util.*;

public class TodoApp {
    private static final String FILE_NAME = "tasks.txt";
    private static final List<Task> tasks = new ArrayList<>();

    static class Task {
        String name;
        boolean completed;

        Task(String name, boolean completed) {
            this.name = name;
            this.completed = completed;
        }

        @Override
        public String toString() {
            return (completed ? "[✓] " : "[ ] ") + name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadTasks();

        while (true) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addTask(scanner);
                case "2" -> viewTasks();
                case "3" -> completeTask(scanner);
                case "4" -> deleteTask(scanner);
                case "5" -> {
                    saveTasks();
                    System.out.println("Tasks saved. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Task cannot be empty.");
            return;
        }

        tasks.add(new Task(name, false));
        saveTasks();
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }

        System.out.println("\nYour tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void completeTask(Scanner scanner) {
        viewTasks();

        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to complete: ");

        try {
            int number = Integer.parseInt(scanner.nextLine());

            if (number < 1 || number > tasks.size()) {
                System.out.println("Invalid task number.");
                return;
            }

            tasks.get(number - 1).completed = true;
            saveTasks();
            System.out.println("Task completed!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        viewTasks();

        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");

        try {
            int number = Integer.parseInt(scanner.nextLine());

            if (number < 1 || number > tasks.size()) {
                System.out.println("Invalid task number.");
                return;
            }

            tasks.remove(number - 1);
            saveTasks();
            System.out.println("Task deleted!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.println(task.completed + "|" + task.name);
            }
        } catch (IOException e) {
            System.out.println("Could not save tasks: " + e.getMessage());
        }
    }

    private static void loadTasks() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int separator = line.indexOf('|');

                if (separator == -1) continue;

                boolean completed = Boolean.parseBoolean(
                        line.substring(0, separator)
                );

                String name = line.substring(separator + 1);

                tasks.add(new Task(name, completed));
            }
        } catch (IOException e) {
            System.out.println("Could not load tasks: " + e.getMessage());
        }
    }
}