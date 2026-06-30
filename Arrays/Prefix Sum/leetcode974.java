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

//print subarrays divisible by k
// import java.util.*;

// class Solution {
//     public static List<List<Integer>> printSubarraysDivByK(int[] nums, int k) {

//         Map<Integer, List<Integer>> map = new HashMap<>();

//         map.put(0, new ArrayList<>());
//         map.get(0).add(-1); // prefix before array starts

//         int sum = 0;

//         List<List<Integer>> result = new ArrayList<>();

//         for (int i = 0; i < nums.length; i++) {

//             sum += nums[i];

//             int rem = ((sum % k) + k) % k;

//             if (!map.containsKey(rem)) {
//                 map.put(rem, new ArrayList<>());
//             }

//             List<Integer> indices = map.get(rem);

//             // every previous index gives a valid subarray
//             for (int startIdx : indices) {
//                 result.add(build(nums, startIdx + 1, i));
//             }

//             indices.add(i);
//         }

//         return result;
//     }

//     private static List<Integer> build(int[] nums, int l, int r) {
//         List<Integer> sub = new ArrayList<>();
//         for (int i = l; i <= r; i++) {
//             sub.add(nums[i]);
//         }
//         return sub;
//     }
// }