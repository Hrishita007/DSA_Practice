//travelling salesman problem using dynamic programming

import java.util.Arrays;
import java.util.Scanner;
public class TravellingSalesman {
    private static int tsp(int[][] graph, int pos, int visited, int n, int[][] dp) {
        if (visited == (1 << n) - 1) {
            return graph[pos][0]; // Return to starting point
        }

        if (dp[pos][visited] != -1) {
            return dp[pos][visited];
        }

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {
            if ((visited & (1 << city)) == 0) { // If city is not visited
                int newAns = graph[pos][city] + tsp(graph, city, visited | (1 << city), n, dp);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[pos][visited] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter the distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = tsp(graph, 0, 1, n, dp);
        System.out.println("The minimum cost of visiting all cities is: " + result);

        sc.close();
    }
}