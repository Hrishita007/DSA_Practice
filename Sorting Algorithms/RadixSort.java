// Radix Sort - Java Implementation
// Note: This implementation sorts non-negative integers.
// Time Complexity:
//   - Worst Case: O(d * (n + b)) where d = number of digits, b = base (10 here)
//   - Average Case: O(d * (n + b))
//   - Best Case: O(d * (n + b))
// Space Complexity: O(n + b) (count array + output array)

import java.util.*;

public class RadixSort {

    // Returns a sorted copy of arr using Radix Sort (base 10) for non-negative integers
    public static int[] radixSort(int[] arr) {
        if (arr == null) return null;
        if (arr.length == 0) return new int[0];

        // Verify non-negative constraint (typical radix sort setup)
        int min = arr[0];
        for (int x : arr) min = Math.min(min, x);
        if (min < 0) {
            throw new IllegalArgumentException("RadixSort implementation here supports non-negative integers only.");
        }

        int[] a = Arrays.copyOf(arr, arr.length);

        int max = a[0];
        for (int x : a) max = Math.max(max, x);

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            a = countingSortByDigit(a, exp);
        }

        return a;
    }

    private static int[] countingSortByDigit(int[] a, int exp) {
        int n = a.length;
        int[] output = new int[n];
        int[] count = new int[10]; // base 10

        // Count occurrences of digits at exp
        for (int i = 0; i < n; i++) {
            int digit = (a[i] / exp) % 10;
            count[digit]++;
        }

        // Convert count to prefix sums
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (iterate from end for stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (a[i] / exp) % 10;
            output[count[digit] - 1] = a[i];
            count[digit]--;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original: " + Arrays.toString(arr));
        int[] sorted = radixSort(arr);
        System.out.println("Sorted:   " + Arrays.toString(sorted));
    }
}

