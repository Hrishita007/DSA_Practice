//Jump Game II
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode45 {
    public int jump(int[] nums) {
        int jumps=0;
        int currentEnd=0;
        int farthest=0;
        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,i+nums[i]);
            if(i==currentEnd){
                jumps++;
                currentEnd=farthest;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        leetcode45 solution = new leetcode45();
        int[] nums = {2,3,1,1,4};
        int minJumps = solution.jump(nums);
        System.out.println("Minimum Jumps: " + minJumps); // Output: 2
    }
}