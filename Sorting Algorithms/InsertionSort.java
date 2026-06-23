// Insertion Sort - Java Implementation
// Time Complexity:
//   - Worst Case: O(n^2)
//   - Average Case: O(n^2)
//   - Best Case (already sorted): O(n)
// Space Complexity: O(1) (in-place)

import java.util.*;

public class InsertionSort {

    // Returns a sorted copy of arr using Insertion Sort
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        int[] a = Arrays.copyOf(arr, n);

        // Build sorted array one element at a time
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original: " + Arrays.toString(arr));
        int[] sorted = insertionSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(sorted));
    }
}

