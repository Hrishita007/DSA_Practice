// Heap Sort - Java Implementation
// Time Complexity:
//   - Worst Case: O(n log n)
//   - Average Case: O(n log n)
//   - Best Case: O(n log n)
// Space Complexity: O(1) (in-place heapify and extraction)

import java.util.*;

public class HeapSort {

    // Returns a sorted copy of arr using Heap Sort
    public static int[] heapSort(int[] arr) {
        if (arr == null) return null;
        int[] a = Arrays.copyOf(arr, arr.length);

        int n = a.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // Call max heapify on reduced heap
            heapify(a, i, 0);
        }

        return a;
    }

    // Ensures subtree rooted at i is a max-heap
    private static void heapify(int[] a, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left] > a[largest]) {
            largest = left;
        }
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(a, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        System.out.println("Original: " + Arrays.toString(arr));
        int[] sorted = heapSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(sorted));
    }
}

