//subarray product less than k
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count=0,product=1,l=0;
        if (k <= 1) {
            return 0;
        }
        for(int r=0;r<nums.length;r++){
            product*=nums[r];
            while(product>=k){
                product/=nums[l];
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        leetcode713 obj = new leetcode713();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(obj.numSubarrayProductLessThanK(nums, k)); // Output: 8
    }
}


// // print subarrays
// int product = 1;
// int l = 0;

// for (int r = 0; r < nums.length; r++) {

//     product *= nums[r];

//     while (product >= k) {
//         product /= nums[l];
//         l++;
//     }

//     // Print all valid subarrays ending at r
//     for (int i = r; i >= l; i--) {

//         System.out.print("[");

//         for (int j = i; j <= r; j++) {
//             System.out.print(nums[j] + " ");
//         }

//         System.out.println("]");
//     }
// }