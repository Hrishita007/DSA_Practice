//find the number of subarrays with sum equal to k
// Time Complexity: O(n), Space Complexity: O(n)
import java.util.HashMap;
class leetcode560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixsum=0;
        int result=0;
        for(int num:nums){
            prefixsum+=num;
            if(map.containsKey(prefixsum-k)){
                result+=map.get(prefixsum-k);
            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return result;
        
    }
    public static void main(String[] args) {
        leetcode560 obj = new leetcode560();
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = obj.subarraySum(nums, k);
        System.out.println(result); // Output: 2
    }
}
