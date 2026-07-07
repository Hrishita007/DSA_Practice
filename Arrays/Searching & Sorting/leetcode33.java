//search in rotated sorted array
//time complexity: O(logn)
//space complexity: O(1)
class leetcode33 {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Found the target
            if (nums[mid] == target)
                return mid;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                // Target lies inside the left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            // Right half is sorted
            else {

                // Target lies inside the right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        leetcode33 solution = new leetcode33();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = solution.search(nums, target);

        System.out.println("Index of target " + target + ": " + result);
    }
}