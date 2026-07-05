//Candies
// Time Complexity: O(n), Space Complexity: O(n)
import java.util.Arrays;
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1])
                candies[i]=candies[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        int total=0;
        for(int candy:candies){
            total+=candy;
        }
        return total;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = {1, 0, 2};
        int result = solution.candy(ratings);
        System.out.println("Minimum candies needed: " + result); // Output: 5
    }
}