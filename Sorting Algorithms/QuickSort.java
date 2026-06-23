// Quick Sort - Java Implementation
// Time Complexity:
//   - Worst Case: O(n^2) (when pivot is always the smallest/largest)
//   - Average Case: O(n log n)
//   - Best Case: O(n log n)
// Space Complexity: O(log n) (recursion stack)

import java.util.*;

public class QuickSort {

    // Returns a sorted copy of arr using Quick Sort
    public static int[] quickSort(int[] arr) {
        if (arr == null) return null;
        int[] a = Arrays.copyOf(arr, arr.length);
        quickSortInPlace(a, 0, a.length - 1);
        return a;
    }

    private static void quickSortInPlace(int[] a, int low, int high) {
        if (low >= high) return;

        int pivotIndex = partition(a, low, high);
        quickSortInPlace(a, low, pivotIndex - 1);
        quickSortInPlace(a, pivotIndex + 1, high);
    }

    // Lomuto partition scheme
    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original: " + Arrays.toString(arr));
        int[] sorted = quickSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(sorted));
    }
}

