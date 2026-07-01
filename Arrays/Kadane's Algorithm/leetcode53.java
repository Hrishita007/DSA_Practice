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