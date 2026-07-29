package Arrays.Hashing;

//longest consecutive sequence
//time complexity: O(n)
//space complexity: O(n)

import java.util.HashSet;
class leetcode128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        if(nums.length == 0)
            return 0;
        for(int n:nums){
            set.add(n);
        }
        int length=1;
        int current;
        int count;
        for(int n:set){
            if(!set.contains(n-1)){
                current=n;
                count=1;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                length=Math.max(length,count);
            } 
                
        }

        return length;
    }
    public static void main(String[] args) {
        leetcode128 solution = new leetcode128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + solution.longestConsecutive(nums));
    }
}