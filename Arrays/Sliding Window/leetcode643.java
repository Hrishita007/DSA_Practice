//Maximum Average Subarray I
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode643 {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for(int i = k; i < nums.length; i++) {

            sum = sum - nums[i-k] + nums[i];

            maxSum = Math.max(maxSum, sum);
        }

        return (double)maxSum / k;
    }
    public static void main(String[] args) {
        leetcode643 obj = new leetcode643();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(obj.findMaxAverage(nums, k));
    }
}

// class Solution {
//     public double findMaxAverage(int[] nums, int k) {

//         int sum = 0;
//         double maxAvg=0;

//         for(int i = 0; i < k; i++) {
//             sum += nums[i];
//         }

//         maxAvg = (double)sum/k;

//         for(int i = k; i < nums.length; i++) {

//             sum = sum - nums[i - k] + nums[i];
//             double avg=(double)sum/k;

//             maxAvg = Math.max(maxAvg, avg);
//         }

//         return maxAvg;
//     }
// }