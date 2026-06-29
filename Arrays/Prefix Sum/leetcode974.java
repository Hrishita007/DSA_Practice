//subarray sums divisible by k
import java.util.HashMap;
class leetcode974 {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            int rem = ((sum % k) + k) % k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        leetcode974 obj = new leetcode974();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int result = obj.subarraysDivByK(nums, k);
        System.out.println(result); // Output: 7
    }
}