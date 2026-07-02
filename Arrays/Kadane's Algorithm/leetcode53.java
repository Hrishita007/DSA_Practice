//maximum subarray sum
class leetcode53 {
    public int maxSubArray(int[] nums) {
        int current=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            current=Math.max(nums[i],current+nums[i]);
            maxSum=Math.max(maxSum,current);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        leetcode53 solution = new leetcode53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = solution.maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum); // Output: 6
    }
}

// import java.util.Arrays;

// // Maximum Subarray Sum print subarray
// class leetcode53 {

//     public int maxSubArray(int[] nums) {

//         int current = nums[0];
//         int maxSum = nums[0];

//         int start = 0;
//         int ansStart = 0;
//         int ansEnd = 0;

//         for (int i = 1; i < nums.length; i++) {

//             if (nums[i] > current + nums[i]) {
//                 current = nums[i];
//                 start = i;
//             } else {
//                 current += nums[i];
//             }

//             if (current > maxSum) {
//                 maxSum = current;
//                 ansStart = start;
//                 ansEnd = i;
//             }
//         }

//         System.out.print("Maximum Subarray: ");
//         for (int i = ansStart; i <= ansEnd; i++) {
//             System.out.print(nums[i] + " ");
//         }
//         System.out.println();

//         return maxSum;
//     }

//     public static void main(String[] args) {

//         leetcode53 solution = new leetcode53();

//         int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

//         int maxSum = solution.maxSubArray(nums);

//         System.out.println("Maximum Subarray Sum: " + maxSum);
//     }
// }