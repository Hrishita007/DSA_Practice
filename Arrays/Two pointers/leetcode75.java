//sort colors dutch national flag problem
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode75 {
    private void swap(int[] nums, int i, int j) {

    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
    public void sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
            swap(nums,low,mid);
            low++;
            mid++;
        }
        else if(nums[mid]==1){
            mid++;
        }
        else{
            swap(nums,mid,high);
            high--;
            }
        }
    }
    public static void main(String[] args) {
        leetcode75 obj = new leetcode75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        obj.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
