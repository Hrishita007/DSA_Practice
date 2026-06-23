// Selection Sort - Java Implementation
// Time Complexity:
//   - Worst Case: O(n^2)
//   - Average Case: O(n^2)
//   - Best Case: O(n^2)
// Space Complexity: O(1) (in-place)

import java.util.*;

public class SelectionSort {

    // Returns a sorted copy of arr using Selection Sort
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        int[] a = Arrays.copyOf(arr, n);

        // Repeatedly place the smallest element into the next position.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap current element with the found minimum element
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original: " + Arrays.toString(arr));
        int[] sorted = selectionSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(sorted));
    }
}

