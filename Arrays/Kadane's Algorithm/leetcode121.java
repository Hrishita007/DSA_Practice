//Best time to buy and sell stock(easy)
// Time Complexity: O(n), Space Complexity: O(1)
class leetcode121 {
    public int maxProfit(int[] prices) {
        int minbuy=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            minbuy=Math.min(minbuy,prices[i]);
            int profit=prices[i]-minbuy;
            maxProfit=Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        leetcode121 solution = new leetcode121();
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit); // Output: 5
    }
}


//using dynamic programming
// class leetcode121 {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         if (n == 0) return 0;

//         int[] dp = new int[n];
//         dp[0] = 0; // No profit on the first day
//         int minPrice = prices[0];

//         for (int i = 1; i < n; i++) {
//             minPrice = Math.min(minPrice, prices[i]);
//             dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
//         }

//         return dp[n - 1];
//     }

//     public static void main(String[] args) {
//         leetcode121 solution = new leetcode121();
//         int[] prices = {7,1,5,3,6,4};
//         int maxProfit = solution.maxProfit(prices);
//         System.out.println("Maximum Profit: " + maxProfit); // Output: 5
//     }
// }