//maximum length of Subarrays with Equal 0s and 1s
// Time Complexity: O(n), Space Complexity: O(n)
import java.util.HashMap;
class leetcode525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        int sum = 0;
        int max = 0;

        for(int i=0;i<nums.length;i++) {

            // update sum\
            sum+=(nums[i]==0)?-1:1;

            if(map.containsKey(sum)) {

                // calculate length
                int length = i - map.get(sum);

                // update max
                max=Math.max(max,length);

            } else {

                // first occurrence
                map.put(sum, i);
            }

        }

        return max;
    }
    public static void main(String[] args) {
        leetcode525 obj = new leetcode525();
        int[] nums = {0, 1, 0, 1, 1, 0};
        int maxLength = obj.findMaxLength(nums);
        System.out.println(maxLength); // Output: 6
    }
}

//count subarrays with equal 0s and 1s
// import java.util.HashMap;

// class Solution {

//     static int countSubarrWithEqualZeroAndOne(int nums[], int n) {

//         HashMap<Integer, Integer> map = new HashMap<>();

//         map.put(0, 1);

//         int sum = 0;
//         int count = 0;

//         for (int i = 0; i < n; i++) {

//             // Convert 0 to -1
//             sum += (nums[i] == 0) ? -1 : 1;

//             // If this prefix sum has appeared before,
//             // all previous occurrences form valid subarrays.
//             if (map.containsKey(sum)) {
//                 count += map.get(sum);
//             }

//             // Increase frequency of current prefix sum
//             map.put(sum, map.getOrDefault(sum, 0) + 1);
//         }

//         return count;
//     }
// }