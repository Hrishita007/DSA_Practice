//Range Sum Query - Immutable
class leetcode303 {
    int[] prefix;

    public leetcode303(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
        return prefix[right];
    }

    return prefix[right] - prefix[left - 1];
        
    }
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        leetcode303 obj = new leetcode303(nums);
        System.out.println(obj.sumRange(0, 2)); // Output: 1
        System.out.println(obj.sumRange(2, 5)); // Output: -1
        System.out.println(obj.sumRange(0, 5)); // Output: -3
    }
}

/**
 * Your leetcode303 object will be instantiated and called as such:
 * leetcode303 obj = new leetcode303(nums);
 * int param_1 = obj.sumRange(left,right);
 */