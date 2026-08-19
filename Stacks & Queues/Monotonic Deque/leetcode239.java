//Sliding Window Maximum
//time complexity: O(n)
//space complexity: O(k) — deque can hold up to k indices.
import java.util.*;
class leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);

            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        leetcode239 obj = new leetcode239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }
}

//brute force solution
// public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
//     int n = nums.length;
//     int[] ans = new int[n - k + 1];
//     for (int i = 0; i <= n - k; i++) {
//         int max = Integer.MIN_VALUE;
//         for (int j = i; j < i + k; j++) {
//             max = Math.max(max, nums[j]);
//         }
//         ans[i] = max;
//     }
//     return ans;
// }

//example usage
// int[] nums = {1,3,-1,-3,5,3,6,7};
// int k = 3;
// leetcode239 obj = new leetcode239();
// int[] result = obj.maxSlidingWindow(nums, k);
// System.out.println(Arrays.toString(result)); // Output: [3,3,5,5,6,7]