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



// import java.util.Arrays;

// // Maximum Product Subarray print subarray
// class leetcode152 {

//     public int maxProduct(int[] nums) {

//         int current = nums[0];
//         int minProduct = nums[0];
//         int maxProduct = nums[0];

//         int currentStart = 0;
//         int minStart = 0;

//         int ansStart = 0;
//         int ansEnd = 0;

//         for (int i = 1; i < nums.length; i++) {

//             int oldCurrent = current;
//             int oldMin = minProduct;

//             int oldCurrentStart = currentStart;
//             int oldMinStart = minStart;

//             // Compute current max
//             if (nums[i] >= oldCurrent * nums[i] &&
//                 nums[i] >= oldMin * nums[i]) {

//                 current = nums[i];
//                 currentStart = i;

//             } else if (oldCurrent * nums[i] >= oldMin * nums[i]) {

//                 current = oldCurrent * nums[i];
//                 currentStart = oldCurrentStart;

//             } else {

//                 current = oldMin * nums[i];
//                 currentStart = oldMinStart;
//             }

//             // Compute current min
//             if (nums[i] <= oldCurrent * nums[i] &&
//                 nums[i] <= oldMin * nums[i]) {

//                 minProduct = nums[i];
//                 minStart = i;

//             } else if (oldCurrent * nums[i] <= oldMin * nums[i]) {

//                 minProduct = oldCurrent * nums[i];
//                 minStart = oldCurrentStart;

//             } else {

//                 minProduct = oldMin * nums[i];
//                 minStart = oldMinStart;
//             }

//             if (current > maxProduct) {
//                 maxProduct = current;
//                 ansStart = currentStart;
//                 ansEnd = i;
//             }
//         }

//         System.out.print("Maximum Product Subarray: ");
//         for (int i = ansStart; i <= ansEnd; i++) {
//             System.out.print(nums[i] + " ");
//         }
//         System.out.println();

//         return maxProduct;
//     }

//     public static void main(String[] args) {

//         leetcode152 solution = new leetcode152();

//         int[] nums = {-2,3,-4};

//         int ans = solution.maxProduct(nums);

//         System.out.println("Maximum Product: " + ans);
//     }
// }