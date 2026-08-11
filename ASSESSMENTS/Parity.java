package ASSESSMENTS;

/* 1. Array Parity Problem

Question:
Given an array, rearrange it so that the 1st element is even, 2nd is odd, 3rd is even, 4th is odd, and so on. Return the minimum number of swaps required. If it is impossible, return -1.

Example:

[3, 2, 4, 5]

After one swap:

[2, 3, 4, 5]

Answer: 1*/
class Parity {
    public int minSwaps(int[] arr) {

        int even = 0;
        int odd = 0;

        for (int n : arr) {
            if (n % 2 == 0)
                even++;
            else
                odd++;
        }

        int evenNeeded = (arr.length + 1) / 2;
        int oddNeeded = arr.length / 2;

        if (even != evenNeeded || odd != oddNeeded)
            return -1;

        int swaps = 0;

        for (int i = 0; i < arr.length; i++) {

            // Even index → needs even
            if (i % 2 == 0 && arr[i] % 2 != 0) {

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] % 2 == 0) {

                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                        swaps++;
                        break;
                    }
                }
            }

            // Odd index → needs odd
            else if (i % 2 != 0 && arr[i] % 2 == 0) {

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] % 2 != 0) {

                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                        swaps++;
                        break;
                    }
                }
            }
        }

        return swaps;
    }
    public static void main(String[] args) {
        Parity parity = new Parity();
        int[] arr = {3, 2, 4, 5};
        int result = parity.minSwaps(arr);
        System.out.println(result); // Output: 1
    }
}