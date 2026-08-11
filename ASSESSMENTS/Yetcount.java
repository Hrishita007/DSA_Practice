package ASSESSMENTS;

/*2. Yet Another Counting Problem

Question:
Given an array of daily prices, count the number of smooth periods.

A smooth period is a contiguous sequence where each day's price is exactly 1 less than the previous day's price.

Individual days also count as smooth periods.

Example
[5, 4, 3]

Smooth periods:

[5]
[4]
[3]
[5,4]
[4,3]
[5,4,3]

Answer:

6 */

class Yetcount {
    public long countSmoothPeriods(int[] prices) {

        long ans = 1;
        long length = 1;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] == prices[i - 1] - 1) {
                length++;
            } else {
                length = 1;
            }

            ans += length;
        }

        return ans;
    }
    public static void main(String[] args) {
        Yetcount yc = new Yetcount();
        int[] prices = {5, 4, 3};
        long result = yc.countSmoothPeriods(prices);
        System.out.println(result); // Output: 6
    }
}
