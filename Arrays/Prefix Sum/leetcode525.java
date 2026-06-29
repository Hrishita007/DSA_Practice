//maximum length of Subarrays with Equal 0s and 1s
import java.util.HashMap;
class leetcode525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        int sum = 0;
        int max = 0;

        for(int i=0;i<nums.length;i++) {

            // update sum\
            sum+=(nums[i]==0)?-1:1;

            if(map.containsKey(sum)) {

                // calculate length
                int length = i - map.get(sum);

                // update max
                max=Math.max(max,length);

            } else {

                // first occurrence
                map.put(sum, i);
            }

        }

        return max;
    }
    public static void main(String[] args) {
        leetcode525 obj = new leetcode525();
        int[] nums = {0, 1, 0, 1, 1, 0};
        int maxLength = obj.findMaxLength(nums);
        System.out.println(maxLength); // Output: 6
    }
}