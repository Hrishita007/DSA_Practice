import java.util.*;

class Solution {

    // Function to find the second smallest element in the array
    public static int secondSmallest(int[] arr, int n) {
        // Edge case: if the array has fewer than 2 elements
        if (n < 2)
            return -1;

        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;

        // Loop through the array to find the second smallest element
        for (int i = 0; i < n; i++) {
            // Update the smallest and second smallest values
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } 
            else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        return second_small; // Return the second smallest element
    }

    // Function to find the second largest element in the array
    public static int secondLargest(int[] arr, int n) {
        // Edge case: if the array has fewer than 2 elements
        if (n < 2)
            return -1;

        int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;

        // Loop through the array to find the second largest element
        for (int i = 0; i < n; i++) {
            // Update the largest and second largest values
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } 
            else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large; // Return the second largest element
    }
}

public class SecondLargestandSmallest {

    public static void main(String[] args) {
        // Array of elementss
        int[] arr = {1, 2, 4, 7, 7, 5};

        // Calculate the size of the array
        int n = arr.length;

        // Find the second smallest and second largest elements
        int sS = Solution.secondSmallest(arr, n);
        int sL = Solution.secondLargest(arr, n);

        // Output the results
        System.out.println("Second smallest is " + sS);
        System.out.println("Second largest is " + sL);
    }
}


//better
// import java.util.*;

// // Class to solve the problem of finding the second smallest and second largest elements
// class Solution {

//     // Method to find the second smallest and second largest elements in the array
//     public static void getElements(int[] arr, int n) {

//         // Edge case: when the array has less than 2 elements
//         if (n == 0 || n == 1) {
//             System.out.println(-1 + " " + -1);  // Print -1 for both second smallest and second largest
//             return;
//         }

//         // Initialize variables to track the smallest, second smallest, largest, and second largest elements
//         int small = Integer.MAX_VALUE, second_small = Integer.MAX_VALUE;
//         int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;

//         // Find the smallest and largest elements in the array
//         for (int i = 0; i < n; i++) {
//             small = Math.min(small, arr[i]);  // Update the smallest element
//             large = Math.max(large, arr[i]);  // Update the largest element
//         }

//         // Find the second smallest and second largest elements
//         for (int i = 0; i < n; i++) {
//             if (arr[i] < second_small && arr[i] != small) {
//                 second_small = arr[i];  // Update second smallest if a smaller element is found
//             }
//             if (arr[i] > second_large && arr[i] != large) {
//                 second_large = arr[i];  // Update second largest if a larger element is found
//             }
//         }

//         // Output the second smallest and second largest elements
//         System.out.println("Second smallest is " + second_small);
//         System.out.println("Second largest is " + second_large);
//     }
// }

// public class Main {

//     public static void main(String[] args) {

//         // Driver code
//         int n = 6;
//         int[] arr = {1, 2, 4, 6, 7, 5};  // Array of elements

//         // Call the function to find and print the second smallest and second largest elements
//         Solution.getElements(arr, n);
//     }
// }

//brute force
// import java.util.Arrays;

// class Solution {

//     // Method to find the second smallest and second largest elements in the array
//     public static void getElements(int[] arr, int n) {
        
//         // Edge case: when the array has less than 2 elements
//         if (n == 0 || n == 1) {
//             System.out.println(-1 + " " + -1);  // Print -1 for both second smallest and second largest
//             return;
//         }

//         // Sort the array to easily find the second smallest and second largest elements
//         Arrays.sort(arr);

//         // Second smallest element is at index 1 after sorting
//         int small = arr[1];

//         // Second largest element is at index n-2 after sorting
//         int large = arr[n - 2];

//         // Output the second smallest and second largest elements
//         System.out.println("Second smallest is " + small);
//         System.out.println("Second largest is " + large);
//     }
// }

// public class Main {

//     public static void main(String[] args) {
        
//         // Initialize the array with elements
//         int[] arr = {1, 2, 4, 6, 7, 5};
        
//         // Calculate the size of the array
//         int n = arr.length;
        
//         // Call the method to find and print the second smallest and second largest elements
//         Solution.getElements(arr, n);
//     }
// }