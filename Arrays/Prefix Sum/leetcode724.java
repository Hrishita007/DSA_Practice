//find the pivot index of an array
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode724 {
    public int pivotIndex(int[] nums) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            int rightsum=total-leftsum-nums[i];
            
            if(leftsum==rightsum) return i;
            leftsum+=nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        leetcode724 obj = new leetcode724();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int pivotIndex = obj.pivotIndex(nums);
        System.out.println(pivotIndex); // Output: 3
    }
}