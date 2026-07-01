//maximum product subarray
class leetcode152 {
    public int maxProduct(int[] nums) {
        int current = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int oldCurrent = current;
            int oldMin = minProduct;

            current = Math.max(nums[i],
                    Math.max(oldCurrent * nums[i], oldMin * nums[i]));

            minProduct = Math.min(nums[i],
                    Math.min(oldCurrent * nums[i], oldMin * nums[i]));

            maxProduct = Math.max(maxProduct, current);
        }

        return maxProduct;
    }
    public static void main(String[] args) {
        leetcode152 solution = new leetcode152();
        int[] nums = {2, 3, -2, 4};
        int maxProduct = solution.maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + maxProduct); // Output: 6
    }
}