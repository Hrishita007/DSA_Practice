package ASSESSMENTS;

/*3. Yet Another Robber Problem
Question

You are given 2 parallel rows of houses, with n houses in each row.

Each house contains some amount of money.

You want to steal the maximum amount of money, but:

You cannot steal from both houses in the same column.
You cannot steal from houses in adjacent columns.
Return the maximum amount you can steal.
Example
2  7  9  3
1  5  2  8

Think column-wise:

Column 0 → 2, 1
Column 1 → 7, 5
Column 2 → 9, 2
Column 3 → 3, 8

For each column, we can take at most one house.

So the best amount from each column is:

2, 7, 9, 8

Now it becomes a normal House Robber problem:

2 + 9 = 11
7 + 8 = 15

Answer:

15 */

class Robber {
    public int maxAmount(int[][] houses) {

        int n = houses[0].length;

        int prev2 = 0;
        int prev1 = 0;

        for (int i = 0; i < n; i++) {

            // We can take only one house from this column
            int currentColumn = Math.max(houses[0][i], houses[1][i]);

            // Either:
            // 1. Don't take this column
            // 2. Take this column + best from 2 columns before
            int current = Math.max(prev1, prev2 + currentColumn);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
    public static void main(String[] args) {
        Robber robber = new Robber();
        int[][] houses = {
            {2, 7, 9, 3},
            {1, 5, 2, 8}
        };
        int result = robber.maxAmount(houses);
        System.out.println(result); // Output: 15
    }
}
