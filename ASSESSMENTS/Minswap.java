package ASSESSMENTS;

// Question 1
// You are given an array arr of length n representing the target display value at each Amazon fulfillment station (stations are in a line from left to right).
// You can do the following operations any number of times (possibly zero):
//  * Choose an index i with 1 \le i \le n - 1 and set all positions 0, 1, \dots, i-1 to arr[i]; this costs i \times \text{arr}[i].
//  * Choose an index i with 0 \le i \le n - 2 and set all positions i+1, i+2, \dots, n-1 to arr[i]; this costs (n - 1 - i) \times \text{arr}[i].
// Compute the minimum total cost to make all array elements equal.
// Example
// Start with \text{arr} = [3, 1, 4, 2]. One optimal sequence is:
//  * Choose i = 1 and set position 0 to \text{arr}[1] = 1. Cost = 1 \times 1 = 1. The array becomes [1, 1, 4, 2].
//  * Choose i = 1 and set positions 2 and 3 to \text{arr}[1] = 1. Cost = (4 - 1 - 1) \times 1 = 2. The array becomes [1, 1, 1, 1].
// Total cost = 1 + 2 = 3. No sequence yields a smaller total cost.
// Function Description
// Complete the function getMinCost in the editor below.
// getMinCost has the following parameter(s):
//  * int arr[n]: the target display value at each Amazon fulfillment station.
// Returns
//  * long: the minimum total cost to make all elements equal.
// Constraints
//  *  *


// Solution:
import java.util.*;
public class Minswap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        long minCost = getMinCost(arr);
        System.out.println(minCost);
    }
public static long getMinCost(List<Integer> arr) {
    int s = arr.size();
    if (s <= 1) return 0;
    
    long mincost = Long.MAX_VALUE;
    int i = 0;
    
    while (i < s) {
        int j = i; 
        
        // Find contiguous block of equal elements
        while (j < s && arr.get(j).equals(arr.get(i))) {
            j++;
        }
        
        long val = arr.get(i);
        long len = j - i;
        long cost = (s - 1 - (len - 1)) * val;
        
        if (cost < mincost) {
            mincost = cost;
        }
        
        i = j; // Move to the next block
    }
    
    return mincost;
}
}

// Your Question: Move an array list containing 0s and 1s in a sorted way such that all 0s are in one part and all 1s are in the other. Determine the minimum swaps. (Function signature: public int minmoves(List<Integer> arr))
// Solution (Adjacent Swaps):
// import java.util.*;
// public class Minswap {

// public int minmoves(List<Integer> arr) {
//     int swapsZeroToLeft = 0;
//     int onesCount = 0;
    
//     int swapsOneToLeft = 0;
//     int zerosCount = 0;
    
//     for (int num : arr) {
//         if (num == 1) {
//             onesCount++;
//             swapsOneToLeft += zerosCount;
//         } else { 
//             zerosCount++;
//             swapsZeroToLeft += onesCount;
//         }
//     }
    
//     return Math.min(swapsZeroToLeft, swapsOneToLeft);
// }
// }
