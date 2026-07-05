//Best time to buy and sell stock II(medium)
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode122 {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }        
        }
        return profit;
    }
    public static void main(String[] args) {
        leetcode122 solution = new leetcode122();
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit); // Output: 7
    }
}