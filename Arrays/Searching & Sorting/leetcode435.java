//Non-overlapping Intervals
//time complexity: O(nlogn) for sorting and O(n) for checking overlaps, so overall O(nlogn)
//space complexity: O(1)
import java.util.*;
class leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int remove=0;
        int[] current = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<current[1]){
                remove++;
            }
            else{
                current= intervals[i];
            }
        }
        return remove;
    }
    public static void main(String[] args) {
        leetcode435 solution = new leetcode435();

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        int result = solution.eraseOverlapIntervals(intervals);

        System.out.println("Minimum number of intervals to remove: " + result);
    }
}