//rotate array to the right by k steps
//time complexity: O(n) where n is the number of elements in the array
//space complexity: O(1) as we are doing it in place
import java.util.Arrays;
class leetcode189 {

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public static void main(String[] args) {
        leetcode189 solution = new leetcode189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Original: " + Arrays.toString(nums));
        solution.rotate(nums, k);
        System.out.println("Rotated:  " + Arrays.toString(nums));
    }
}