//maximum consecutive ones III
class leetcode1004 {
    public int longestOnes(int[] nums, int k) {
    int count = 0;
    int l = 0;
    int max=0;

    for(int r = 0; r < nums.length; r++) {

        if(nums[r] == 0)
            count++;

        while(count > k) {

            if(nums[l] == 0)
                count--;

            l++;
        }

        max = Math.max(max, r - l + 1);
    }
    return max;
    }
    public static void main(String[] args) {
        leetcode1004 solution = new leetcode1004();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = solution.longestOnes(nums, k);
        System.out.println(result); // Output: 6
    }
}