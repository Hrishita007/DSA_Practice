//Remove Duplicates from Sorted Array
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode26 {
    public int removeDuplicates(int[] nums) {
        int s=0,f=0;
        for(f=0;f<nums.length;f++){
            if(nums[f]!=nums[s]){
                s++;
                nums[s]=nums[f];
            }
        }
        return s+1;
        
    }
    public static void main(String[] args) {
        leetcode26 solution = new leetcode26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int newLength = solution.removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}