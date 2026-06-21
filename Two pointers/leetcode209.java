//Maximum size suarray sum
public class leetcode209 {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with sum 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            // Only add the current sum to the map if it doesn't exist
            // This ensures we keep the earliest index for the sum
            map.putIfAbsent(sum, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        leetcode209 solution = new leetcode209();
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        int result = solution.maxSubArrayLen(nums, k);
        System.out.println(result); // Output: 4
    }
}