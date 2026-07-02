//Best time to buy and sell stock II(medium)
class eetcode122 {
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
        eetcode122 solution = new eetcode122();
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit); // Output: 7
    }
}