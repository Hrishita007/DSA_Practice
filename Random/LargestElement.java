// import java.util.Arrays;

// class Solution {

//     // Function to sort the array and return the largest element
//     public static int sortArr(int[] arr) {
//         // Sort the array in ascending order
//         Arrays.sort(arr);
        
//         // Return the last element (largest element) after sorting
//         return arr[arr.length - 1];
//     }
// }

// public class Main {

//     public static void main(String[] args) {
//         // Initialize arrays
//         int[] arr1 = {2, 5, 1, 3, 0};
//         int[] arr2 = {8, 10, 5, 7, 9};
        
//         // Find and output the largest element in both arrays
//         System.out.println("The Largest element in the array is: " + Solution.sortArr(arr1));
//         System.out.println("The Largest element in the array is: " + Solution.sortArr(arr2));
//     }
// }


//Optimal Solution: The optimal solution to find the largest element in an array is to iterate through the array once and keep track of the maximum value found. This approach has a time complexity of O(n) and does not require sorting the entire array, which has a time complexity of O(n log n).
class Solution {

    // Function to find the largest element in the array
    public static int findLargestElement(int[] arr, int n) {
        int max = arr[0];  // Initialize max with the first element in the array

        // Iterate through the array to find the maximum element
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {  // If the current element is greater than max, update max
                max = arr[i];
            }
        }

        return max;  // Return the largest element found
    }
}

public class LargestElement {

    public static void main(String[] args) {
        // Array 1
        int[] arr1 = {2, 5, 1, 3, 0};
        int n = arr1.length;  // Size of the array
        int max = Solution.findLargestElement(arr1, n);  // Call the function to find the largest element
        System.out.println("The largest element in the array is: " + max);  // Output the result

        // Array 2
        int[] arr2 = {8, 10, 5, 7, 9};
        n = arr2.length;  // Size of the array
        max = Solution.findLargestElement(arr2, n);  // Call the function to find the largest element
        System.out.println("The largest element in the array is: " + max);  // Output the result
    }
}