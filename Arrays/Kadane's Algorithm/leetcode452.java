// Minimum Number of Arrows to Burst Balloons
// Time Complexity: O(n log n), Space Complexity: O(1)

import java.util.Arrays;

class leetcode452 {
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) return 0;

        // sort by end
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {

            // if current balloon starts after arrow position → new arrow
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
    public static void main(String[] args) {
        leetcode452 solution = new leetcode452();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int result = solution.findMinArrowShots(points);
        System.out.println("Minimum number of arrows needed: " + result); // Output: 2
    }
}