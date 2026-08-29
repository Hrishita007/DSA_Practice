import java.util.*;

public class ExpenseAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Double> expenses = new HashMap<>();

        System.out.print("How many expenses do you want to enter? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter category (Food/Travel/Shopping/etc.): ");
            String category = sc.nextLine();

            System.out.print("Enter amount: ₹");
            double amount = sc.nextDouble();
            sc.nextLine();

            expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
        }

        double total = 0;

        System.out.println("\n===== EXPENSE REPORT =====");

        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.printf("%-15s ₹%.2f%n",
                    entry.getKey(), entry.getValue());
            total += entry.getValue();
        }

        System.out.println("---------------------------");
        System.out.printf("Total spent: ₹%.2f%n", total);

        String highestCategory = "";
        double highestAmount = 0;

        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            if (entry.getValue() > highestAmount) {
                highestAmount = entry.getValue();
                highestCategory = entry.getKey();
            }
        }

        System.out.println("Highest spending: " + highestCategory);
        System.out.printf("Amount: ₹%.2f%n", highestAmount);

        if (total > 0) {
            double percentage = (highestAmount / total) * 100;
            System.out.printf(
                    "%s accounts for %.1f%% of your spending.%n",
                    highestCategory, percentage);
        }

        sc.close();
    }
}