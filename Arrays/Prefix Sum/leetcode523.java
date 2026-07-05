//continuous subarray sum equals k
// Time Complexity: O(n), Space Complexity: O(n)
import java.util.HashMap;
class leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int rem = sum % k;
            if (rem < 0) rem += k;

            Integer prev = map.get(rem);

            if (prev != null) {
                if (i - prev >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }

        return false;
    }
    public static void main(String[] args) {
        leetcode523 obj = new leetcode523();
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        boolean result = obj.checkSubarraySum(nums, k);
        System.out.println(result); // Output: true
    }
}