//merge intervals
//time complexity: O(nlogn) for sorting and O(n) for merging, so overall O(nlogn)
//space complexity: O(n) for the output array
import java.util.*;
class leetcode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans=new ArrayList<>();
        int[] current=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=current[1])
                current[1]=Math.max(current[1],intervals[i][1]);
            
            else{
                ans.add(current);
                current=intervals[i];                
            }            
        }
        ans.add(current);
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        leetcode56 solution = new leetcode56();

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = solution.merge(intervals);

        System.out.println("Merged Intervals: ");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}