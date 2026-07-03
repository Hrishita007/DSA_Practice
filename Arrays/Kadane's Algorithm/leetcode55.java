//Jump Game
class leetcode55 {
    public boolean canJump(int[] nums) {
        int farthest=nums[0];
        for(int i=0;i<nums.length;i++){

            if(i>farthest) return false;
            int far= i+nums[i];
            farthest=Math.max(farthest,far);
        }
        return true;
    }
    public static void main(String[] args) {
        leetcode55 solution = new leetcode55();
        int[] nums = {2,3,1,1,4};
        boolean canJump = solution.canJump(nums);
        System.out.println("Can Jump: " + canJump); // Output: true
    }
}