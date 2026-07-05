//Insert Interval
//time complexity: O(n)
//space complexity: O(n) for the output array
import java.util.*;
class leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals completely before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // 2. Merge all overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged interval
        ans.add(newInterval);

        // 3. Add all remaining intervals
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        leetcode57 solution = new leetcode57();

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = solution.insert(intervals, newInterval);

        System.out.println("Intervals after insertion: ");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}