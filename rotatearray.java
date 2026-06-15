// //right rotation of an array by k positions
// public class RotateArray {

//     static void rotateRight(int[] arr, int k) {
//         int n = arr.length;
//         if (n == 0) return;

//         k = k % n;

//         int[] temp = new int[k];

//         // Store last k elements
//         for (int i = n - k; i < n; i++) {
//             temp[i - (n - k)] = arr[i];
//         }

//         // Shift remaining elements right
//         for (int i = n - k - 1; i >= 0; i--) {
//             arr[i + k] = arr[i];
//         }

//         // Copy temp elements to beginning
//         for (int i = 0; i < k; i++) {
//             arr[i] = temp[i];
//         }
//     }

//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 4, 5, 6, 7};
//         int k = 2;

//         rotateRight(arr, k);

//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//     }
// }


// //left rotation of an array by k positions
// public class RotateArray {

//     static void rotateLeft(int[] arr, int k) {
//         int n = arr.length;
//         if (n == 0) return;

//         k = k % n;

//         int[] temp = new int[k];

//         // Store first k elements
//         for (int i = 0; i < k; i++) {
//             temp[i] = arr[i];
//         }

//         // Shift remaining elements left
//         for (int i = k; i < n; i++) {
//             arr[i - k] = arr[i];
//         }

//         // Place temp elements at end
//         for (int i = 0; i < k; i++) {
//             arr[n - k + i] = temp[i];
//         }
//     }

//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 4, 5, 6, 7};
//         int k = 2;

//         rotateLeft(arr, k);

//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//     }
// }

public class rotatearray {

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;

        k = k % n;

        // Reverse entire array
        reverse(arr, 0, n - 1);

        // Reverse first k elements
        reverse(arr, 0, k - 1);

        // Reverse remaining elements
        reverse(arr, k, n - 1);
    }

    static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;

        k = k % n;

        // Reverse first k elements
        reverse(arr, 0, k - 1);

        // Reverse remaining elements
        reverse(arr, k, n - 1);

        // Reverse entire array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        rotateRight(arr, k);

        System.out.println("Right Rotation:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};

        rotateLeft(arr2, k);

        System.out.println("Left Rotation:");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }
}