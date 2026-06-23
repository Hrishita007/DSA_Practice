class leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,sum=0,minlen=Integer.MAX_VALUE;
        for(r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>=target){
                minlen=Math.min(minlen,r-l+1);
                sum-=nums[l];
                l++;
                }
        }
        if(minlen==Integer.MAX_VALUE)
                return 0;
    return minlen;
    }
    public static void main(String[] args) {
        leetcode209 obj = new leetcode209();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(obj.minSubArrayLen(target, nums));
    }
}