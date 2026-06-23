// Counting Sort - Java Implementation
// Note: Best suited for non-negative integers.
// Time Complexity:
//   - Worst Case: O(n + k)
//   - Average Case: O(n + k)
//   - Best Case: O(n + k)
// Space Complexity: O(k) (counts array)

import java.util.*;

public class CountingSort {

    // Returns a sorted copy of arr using Counting Sort
    public static int[] countingSort(int[] arr) {
        if (arr == null) return null;
        if (arr.length == 0) return new int[0];

        int min = arr[0];
        int max = arr[0];
        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        // Shift values if negative numbers exist
        int offset = -min;
        int k = max - min + 1;

        int[] count = new int[k];

        // Count frequency
        for (int x : arr) {
            count[x + offset]++;
        }

        // Build output
        int[] sorted = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (count[i] > 0) {
                sorted[idx++] = i - offset;
                count[i]--;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original: " + Arrays.toString(arr));
        int[] sorted = countingSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(sorted));
    }
}

