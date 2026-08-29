import java.util.*;

public class StudyAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        String[] subjects = new String[n];
        double[] marks = new double[n];

        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter subject name: ");
            subjects[i] = sc.next();

            System.out.print("Enter marks out of 100: ");
            marks[i] = sc.nextDouble();

            total += marks[i];
        }

        double average = total / n;

        int bestIndex = 0;
        int worstIndex = 0;

        for (int i = 1; i < n; i++) {
            if (marks[i] > marks[bestIndex]) {
                bestIndex = i;
            }

            if (marks[i] < marks[worstIndex]) {
                worstIndex = i;
            }
        }

        System.out.println("\n===== STUDY PERFORMANCE =====");

        for (int i = 0; i < n; i++) {
            String performance;

            if (marks[i] >= 90)
                performance = "Excellent";
            else if (marks[i] >= 75)
                performance = "Good";
            else if (marks[i] >= 50)
                performance = "Needs Improvement";
            else
                performance = "Critical";

            System.out.printf("%-15s %.1f - %s%n",
                    subjects[i], marks[i], performance);
        }

        System.out.println("\nAverage: " + String.format("%.2f", average));
        System.out.println("Strongest subject: " + subjects[bestIndex]);
        System.out.println("Weakest subject: " + subjects[worstIndex]);

        if (average >= 75) {
            System.out.println("Overall analysis: You are performing well!");
        } else if (average >= 50) {
            System.out.println("Overall analysis: You have a good base, but there is room to improve.");
        } else {
            System.out.println("Overall analysis: Focus on strengthening your fundamentals.");
        }

        sc.close();
    }
}