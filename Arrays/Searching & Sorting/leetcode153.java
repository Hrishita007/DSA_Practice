//minimum in a rotated sorted array
//time complexity: O(logn)
//space complexity: O(1)
class leetcode153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid=(low+high)/2;
            if (nums[low] < nums[high]) {
                return nums[low];
            }
            else if (nums[low] <= nums[mid]) {
                low=mid+1;
            } else {
                high=mid;
            }
        
        }
        return nums[low];
    }
    public static void main(String[] args) {
        leetcode153 solution = new leetcode153();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int result = solution.findMin(nums);

        System.out.println("Minimum element in the rotated sorted array: " + result);
    }
}