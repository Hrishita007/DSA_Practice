//Bucket Sort is a sorting algorithm that distributes elements into a number of buckets.
//  Each bucket is then sorted individually, either using a different sorting algorithm or 
// by recursively applying the bucket sort algorithm.
//time complexity: O(n + k) where n is the number of elements and k is the number of buckets
//average case: O(n + k) where n is the number of elements and k is the number of buckets
//best case: O(n + k) where n is the number of elements and k is the number of buckets
//worst case: O(n^2) when all elements are in the same bucket
//space complexity: O(n + k) where n is the number of elements and k is the number of buckets

import java.util.*;
public class BucketSort {
    public static void bucketSort(int[] arr, int numBuckets) {
        if (arr == null || arr.length == 0 || numBuckets <= 0) return;

        // Find the maximum value in the array
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // Create buckets
        List<List<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute input array values into buckets
        for (int value : arr) {
            int bucketIndex = (value * numBuckets) / (maxValue + 1);
            buckets.get(bucketIndex).add(value);
        }

        // Sort each bucket and concatenate results
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // You can use any sorting algorithm here
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original: " + Arrays.toString(arr));
        bucketSort(arr, 5); // Using 5 buckets
        System.out.println("Sorted:   " + Arrays.toString(arr));
    }
    
}
