//Move Zeroes
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode283 {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        for(j=0;j<nums.length;j++){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
        }
        for(int k=i;k<nums.length;k++){
            nums[k]=0;
        }
    }
    public static void main(String[] args) {
        leetcode283 solution = new leetcode283();

        int[] nums = {0, 1, 0, 3, 12};

        solution.moveZeroes(nums);

        System.out.print("Result: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}