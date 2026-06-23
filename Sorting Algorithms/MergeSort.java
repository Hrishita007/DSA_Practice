// Merge Sort - Java Implementation
// Time Complexity:
//   - Worst Case: O(n log n)
//   - Average Case: O(n log n)
//   - Best Case: O(n log n)
// Space Complexity: O(n) (because of temporary arrays used in merging)

import java.util.*;

public class MergeSort {

    // Returns a sorted copy of arr using Merge Sort
    public static int[] mergeSort(int[] arr) {
        if (arr == null) return null;
        int[] a = Arrays.copyOf(arr, arr.length);
        mergeSortInPlace(a, 0, a.length - 1);
        return a;
    }

    private static void mergeSortInPlace(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortInPlace(a, left, mid);
        mergeSortInPlace(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = a[left + i];
        for (int j = 0; j < n2; j++) R[j] = a[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) a[k++] = L[i++];
            else a[k++] = R[j++];
        }

        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original: " + Arrays.toString(arr));
        int[] sorted = mergeSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(sorted));
    }
}

