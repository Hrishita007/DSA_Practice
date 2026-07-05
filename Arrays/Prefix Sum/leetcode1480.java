//running sum of 1d array
// Time Complexity: O(n), Space Complexity: O(1) (ignoring output array) 
import java.util.Arrays;
class leetcode1480 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
        
    }
    public static void main(String[] args) {
        leetcode1480 obj = new leetcode1480();
        int[] nums = {1, 2, 3, 4};
        int[] result = obj.runningSum(nums);
        System.out.println(Arrays.toString(result)); // Output: [1, 3, 6, 10]
    }
}