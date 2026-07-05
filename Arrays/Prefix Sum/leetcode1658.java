//minimum operations to reduce x to zero
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode1658 {
    public int minOperations(int[] nums, int x) {
        int l=0;
        int totsum=0;
        int sum=0;
        int maxlength=-1;
        for(int num:nums)
            totsum+=num;
        
        int target = totsum - x;

        if (target < 0) return -1;

        if (target == 0) return nums.length;
        
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>target){
                sum-=nums[l];
                l++;
            }
            if(sum==target) maxlength=Math.max(maxlength,r-l+1); 
        }
        if (maxlength == -1)
                return -1;
        return nums.length-maxlength;
    }
    public static void main(String[] args) {
        leetcode1658 obj = new leetcode1658();
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        int result = obj.minOperations(nums, x);
        System.out.println(result); // Output: 2
    }
}