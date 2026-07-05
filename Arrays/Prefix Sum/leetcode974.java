//subarray sums divisible by k
// Time Complexity: O(n), Space Complexity: O(n)
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

// class leetcode974 {
//     public int subarraysDivByK(int[] nums, int k) {

//         HashMap<Integer, Integer> map = new HashMap<>();
//         HashMap<Integer, List<Integer>> indicesMap = new HashMap<>();

//         map.put(0, 1);

//         indicesMap.put(0, new ArrayList<>());
//         indicesMap.get(0).add(-1); // prefix start

//         int sum = 0;
//         int count = 0;

//         for (int i = 0; i < nums.length; i++) {

//             sum += nums[i];

//             int rem = ((sum % k) + k) % k;

//             // ---- PRINT LOGIC ADDED ----
//             if (indicesMap.containsKey(rem)) {
//                 for (int start : indicesMap.get(rem)) {
//                     System.out.println("Subarray: " + (start + 1) + " to " + i);
//                 }
//             }

//             // ---- YOUR ORIGINAL LOGIC ----
//             count += map.getOrDefault(rem, 0);
//             map.put(rem, map.getOrDefault(rem, 0) + 1);

//             // ---- STORE INDEX FOR PRINTING ----
//             indicesMap.putIfAbsent(rem, new ArrayList<>());
//             indicesMap.get(rem).add(i);
//         }

//         return count;
//     }

//     public static void main(String[] args) {
//         leetcode974 obj = new leetcode974();
//         int[] nums = {4, 5, 0, -2, -3, 1};
//         int k = 5;

//         int result = obj.subarraysDivByK(nums, k);
//         System.out.println("Count = " + result);
//     }
// }