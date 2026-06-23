// Bubble Sort - Java Implementation
// Time Complexity:
//   - Worst Case: O(n^2)
//   - Average Case: O(n^2)
//   - Best Case (Already sorted): O(n)
// Space Complexity: O(1) (in-place, iterative)

import java.util.*;

public class BubbleSort {

    // Returns a sorted copy of arr using Bubble Sort
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int[] a = Arrays.copyOf(arr, n);

        // After each pass, the largest element among remaining unsorted
        // elements moves to its correct position.
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: if no swaps in a pass, array is already sorted
            if (!swapped) break;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        System.out.println("Original: " + Arrays.toString(arr));
        int[] sorted = bubbleSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(sorted));
    }
}

