import java.util.*;
class leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4)
            return new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for(int j=i+1;j<nums.length-2;j++){
                int l=j+1;
                int r=nums.length-1;
                while(l<r){
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                    } 
                    else if(sum<target)
                        l++;
                    else 
                        r--;
                }
            }

    }
    return new ArrayList<>(result);
}
public static void main(String[] args) {
    leetcode18 solution = new leetcode18();
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    List<List<Integer>> result = solution.fourSum(nums, target);
    System.out.println(result);
}
}